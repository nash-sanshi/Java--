package src.main.java.JDBC3;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBUtilsTest {
    QueryRunner queryRunner = new QueryRunner();
    /**
     * 测试QueryRunner类的update方法
     * 该方法可用于insert，update和delete
     */
    @Test
    public void testQueryRunnerUpdate() {
        //1、创建QueryRunner的实现类

        String sql = "delete from customers where id in (?,?)";
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            //2、使用其update方法
            queryRunner.update(connection, sql, 5, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     * QueryRunner的query方法的返回值取决于与其ResultSetHandler参数的handle方法的返回值
     */
    @Test
    public void testQuery() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers";
            Object object = queryRunner.query(connection, sql, new MyResultSetHandler());
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }

    class MyResultSetHandler implements ResultSetHandler {
        @Override
        public Object handle(ResultSet resultSet) throws SQLException {
//            System.out.println("handler......");
//            return "dfbz";
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                Customer customer = new Customer(id, name, email, birth);
                customers.add(customer);
            }
            return customers;
        }
    }

    /**
     * BeanHandler：把结果集的第一条记录转为创建BeanHandler对象时传入的class参数对应的对象
     */
    @Test
    public void testBeanHandler() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers where id >= ?";
            Customer customer = (Customer) queryRunner.query(connection, sql, new BeanHandler(Customer.class),3);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     * BeanListHandler:把结果集转为一个List，该list不为null，但可能为空集合（size()方法返回0）
     * 若sql语句能够查询到记录，list中存放创建BeanListHandler传入的Class对象对应的对象
     */
    @Test
    public void testBeanListHandler() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers";
            List<Customer> customers = queryRunner.query(connection, sql, new BeanListHandler<>(Customer.class));
            System.out.println(customers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     * MapHadler:返回SQL对应的第一条记录对应的map对象
     * 键：SQL查询的列名（不是别名）
     * 值：列的值
     */
    @Test
    public void testMapHadler() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers";
            Map<String ,Object> reslut = queryRunner.query(connection, sql, new MapHandler());
            System.out.println(reslut);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     *MapListHadler:将结果集转为一个Map 的List
     * Map对应查询的一条记录
     * 键：SQL查询的列名（不是别名）
     * 值：列的值
     * MapListHadler：返回的多条记录对应的Map的集合
     */
    @Test
    public void testMapListHadler() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers";
            List<Map<String ,Object>> reslut = queryRunner.query(connection, sql, new MapListHandler());
            System.out.println(reslut);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     * ScalarHandler:把结果集转为一个数值（可以是任意基本数据类型和字符串data等）返回
     */
    @Test
    public void testScalarHandler() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select name from customers";
            Object reslut = queryRunner.query(connection, sql, new ScalarHandler());
            System.out.println(reslut);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }
}
