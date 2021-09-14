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
     * ����QueryRunner���update����
     * �÷���������insert��update��delete
     */
    @Test
    public void testQueryRunnerUpdate() {
        //1������QueryRunner��ʵ����

        String sql = "delete from customers where id in (?,?)";
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            //2��ʹ����update����
            queryRunner.update(connection, sql, 5, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(null,connection);
        }
    }

    /**
     * QueryRunner��query�����ķ���ֵȡ��������ResultSetHandler������handle�����ķ���ֵ
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
     * BeanHandler���ѽ�����ĵ�һ����¼תΪ����BeanHandler����ʱ�����class������Ӧ�Ķ���
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
     * BeanListHandler:�ѽ����תΪһ��List����list��Ϊnull��������Ϊ�ռ��ϣ�size()��������0��
     * ��sql����ܹ���ѯ����¼��list�д�Ŵ���BeanListHandler�����Class�����Ӧ�Ķ���
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
     * MapHadler:����SQL��Ӧ�ĵ�һ����¼��Ӧ��map����
     * ����SQL��ѯ�����������Ǳ�����
     * ֵ���е�ֵ
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
     *MapListHadler:�������תΪһ��Map ��List
     * Map��Ӧ��ѯ��һ����¼
     * ����SQL��ѯ�����������Ǳ�����
     * ֵ���е�ֵ
     * MapListHadler�����صĶ�����¼��Ӧ��Map�ļ���
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
     * ScalarHandler:�ѽ����תΪһ����ֵ����������������������ͺ��ַ���data�ȣ�����
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
