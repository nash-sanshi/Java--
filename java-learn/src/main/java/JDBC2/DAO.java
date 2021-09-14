package src.main.java.JDBC2;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
    /*1��DAO��Data Access Object ���ݷ��ʶ���
    ����������Ϣ���࣬�����˶�����CRUD��create��read��update��delete�������������κ�ҵ����ص���Ϣ��ʵ�ֹ��ܵ�ģ�黯���������ڴ����ά��������

            ʹ��JDBC��дDAO���ܻ�����ķ���
    //insert update delete���������԰���������
    void update(String sql,Object...args)
    //��ѯһ����¼�����ض�Ӧ�Ķ���
    <T> T get(Class<T> clazz,String sql,Object...args);
    //��ѯ������¼�����ض�Ӧ�Ķ��󼯺�
    <T> List<T> getForList(Class<T> clazz,String sql,Object...args);
    //����ĳ����¼��ĳһ���ֶε�ֵ��һ��ͳ�Ƶ�ֵ��һ���ж�������¼�ȵȣ�
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

    //��ѯһ����¼�����ض�Ӧ�Ķ���
    public <T> T get(Class<T> clazz,String sql,Object...args) {
        /*T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1����ȡConnection
            connection = JDBCTools.getConnection();
            //2����ȡPreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //3�����ռλ��
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //4�����в�ѯ���õ�ResultSet
            resultSet = preparedStatement.executeQuery();
            //5����ResultSet���м�¼��׼��һ��Map<String,Obejct>����������еı�����ֵ������е�ֵ
            if (resultSet.next()) {
                Map<String, Object> values = new HashMap<>();
                //6���õ�ResultSetMetaData����
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                //7������ResultSet����ָ�������ƶ�һ����λ
                //8����ResultSetMetaData����õ�������ж�����
                int cloumnCount = resultSetMetaData.getColumnCount();
                //9����ResultSetMetaData�õ�ÿһ���е���������ResultSet�õ������ÿһ���е�ֵ
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLable = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(columnLable);
                    //10�����Map�Ķ���
                    values.put(columnLable, columnValue);
                }
                //11���÷��䴴��Class��Ӧ�Ķ���
                entity = clazz.newInstance();
                //12������Map�����÷��������������ֵ��������ΪMap�е�key����ֵΪMap�е�value
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

    //��ѯ������¼�����ض�Ӧ�Ķ��󼯺�
    public <T> List<T> getForList(Class<T> clazz, String sql, Object...args) {
        List<T> list = new ArrayList<>();
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1���õ������
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //2�������������õ�Map��list������һ��Map�������һ����¼Map��keyΪResultSet���еı���
            //Map��valueΪ�е�ֵ
            resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> values = handleResultSetToMapList(resultSet);
            //3����Map��ListתΪClazz��Ӧ��List��
            //����Map��key��Ϊclazz��Ӧ�Ķ����PropertyName
            //��Map��value��Ϊclazz��Ӧ�Ķ����PropertyValue
            list = transfterMapListToBeanList(clazz, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        return list;
    }

    //����ĳ����¼��ĳһ���ֶε�ֵ��һ��ͳ�Ƶ�ֵ��һ���ж�������¼�ȵȣ�
    public <E> E getForValue(String sql,Object...args) {
        //1���õ���������ý����Ӧ��ֻ��һ�У���ֻ��һ��
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //�õ������
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
        //2��ȡ�ý��
        return null;
    }

    private <T> List<T> transfterMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values) throws Exception {
        //12���ж�List�Ƿ�Ϊ�ռ��ϣ�����Ϊ�գ������List���õ�һ������Map�����ٰ�һ��MapתΪһ��class�����Եĵ�Object
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
                //13����Object����list��
                result.add(bean);
            }
        }
        return result;
    }

    /**
     *�����������õ�map��һ��list������һ��Map�����Ӧһ����¼
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private List<Map<String, Object>> handleResultSetToMapList(ResultSet resultSet) throws SQLException {
        //5��׼��һ��List<Map<String,Obejct>>����������еı�����ֵ������е�ֵ������һ��Map�����Ӧһ����¼
        List<Map<String, Object>> values = new ArrayList<>();
        //ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<String> columnLabels = getColumnLabels(resultSet);
        Map<String,Object> map = null;
        //7������ResultSet��ʹ��whileѭ��
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
            //11����һ����¼��һ��Map�������5׼����List��
            values.add(map);
        }
        return values;
    }

    /**
     * ��ȡ�������ColumnLabels��Ӧ��List
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
