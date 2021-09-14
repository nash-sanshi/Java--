package src.main.java.JDBC2;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
    /*1、DAO：Data Access Object 数据访问对象
    反问数据信息的类，包含了对数据CRUD（create，read，update，delete），而不包含任何业务相关的信息，实现功能的模块化，更有利于代码的维护和升级

            使用JDBC编写DAO可能会包含的方法
    //insert update delete操作都可以包含在其中
    void update(String sql,Object...args)
    //查询一条记录，返回对应的对象
    <T> T get(Class<T> clazz,String sql,Object...args);
    //查询多条记录，返回对应的对象集合
    <T> List<T> getForList(Class<T> clazz,String sql,Object...args);
    //返回某条记录的某一个字段的值或一个统计的值（一共有多少条记录等等）
    <E> E getForValue(String sql,Object...args)*/
    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(preparedStatement, connection);
        }
    }

    //查询一条记录，返回对应的对象
    public <T> T get(Class<T> clazz,String sql,Object...args) {
        /*T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1、获取Connection
            connection = JDBCTools.getConnection();
            //2、获取PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //3、填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、进行查询，得到ResultSet
            resultSet = preparedStatement.executeQuery();
            //5、用ResultSet中有记录，准备一个Map<String,Obejct>：键，存放列的别名；值，存放列的值
            if (resultSet.next()) {
                Map<String, Object> values = new HashMap<>();
                //6、得到ResultSetMetaData对象
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                //7、处理ResultSet，把指针向下移动一个单位
                //8、由ResultSetMetaData对象得到结果集有多少列
                int cloumnCount = resultSetMetaData.getColumnCount();
                //9、由ResultSetMetaData得到每一个列的列名，由ResultSet得到具体的每一个列的值
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLable = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(columnLable);
                    //10、填充Map的对象
                    values.put(columnLable, columnValue);
                }
                //11、用反射创建Class对应的对象
                entity = clazz.newInstance();
                //12、遍历Map对象，用反射填充对象的属性值，属性名为Map中的key属性值为Map中的value
                for (Map.Entry<String,Object> entry : values.entrySet()) {
                    String fieldName = entry.getKey();
                    Object fieldValue = entry.getValue();
                    //ReflectionUtils.setFieldValue(entity,fieldName,fieldValue);
                    BeanUtils.setProperty(entity,fieldName,fieldValue);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }*/
        List<T> result = getForList(clazz, sql, args);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    //查询多条记录，返回对应的对象集合
    public <T> List<T> getForList(Class<T> clazz, String sql, Object...args) {
        List<T> list = new ArrayList<>();
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1、得到结果集
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //2、处理结果集，得到Map的list，其中一个Map对象就是一条记录Map的key为ResultSet中列的别名
            //Map的value为列的值
            resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> values = handleResultSetToMapList(resultSet);
            //3、把Map的List转为Clazz对应的List，
            //其中Map的key即为clazz对应的对象的PropertyName
            //而Map的value即为clazz对应的对象的PropertyValue
            list = transfterMapListToBeanList(clazz, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    //返回某条记录的某一个字段的值或一个统计的值（一共有多少条记录等等）
    public <E> E getForValue(String sql,Object...args) {
        //1、得到结果集：该结果集应该只有一行，且只有一列
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //得到结果集
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (E)resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        //2、取得结果
        return null;
    }

    private <T> List<T> transfterMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values) throws Exception {
        //12、判断List是否为空集合，若不为空，则遍历List，得到一个个的Map对象，再把一个Map转为一个class参数对的的Object
        List<T> result = new ArrayList<>();
        T bean = null;
        if (values.size() > 0) {
            for (Map<String ,Object> m: values) {
                bean = clazz.newInstance();
                for (Map.Entry<String, Object> entry : m.entrySet()) {
                    String propertyName = entry.getKey();
                    Object value = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,value);
                }
                //13、把Object对象list中
                result.add(bean);
            }
        }
        return result;
    }

    /**
     *处理结果集，得到map的一个list，其中一个Map对象对应一条记录
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private List<Map<String, Object>> handleResultSetToMapList(ResultSet resultSet) throws SQLException {
        //5、准备一个List<Map<String,Obejct>>，键：存放列的别名，值：存放列的值，其中一个Map对象对应一条记录
        List<Map<String, Object>> values = new ArrayList<>();
        //ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<String> columnLabels = getColumnLabels(resultSet);
        Map<String,Object> map = null;
        //7、处理ResultSet，使用while循环
        while (resultSet.next()) {
            map = new HashMap<>();
            /*for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                Object columnValue = resultSet.getObject(i + 1);
                map.put(columnLabel, columnValue);
            }*/
            for (String columnLabel1 : columnLabels) {
                Object value = resultSet.getObject(columnLabel1);
                map.put(columnLabel1, value);
            }
            //11、把一条记录的一个Map对象放入5准备的List中
            values.add(map);
        }
        return values;
    }

    /**
     * 获取结果集的ColumnLabels对应的List
     */
    private List<String> getColumnLabels(ResultSet resultSet) throws SQLException {
        List<String> labels = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
            labels.add(resultSetMetaData.getColumnLabel(i + 1));
        }
        return labels;
    }
}
