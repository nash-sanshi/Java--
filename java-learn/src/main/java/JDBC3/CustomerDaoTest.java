package src.main.java.JDBC3;

import org.junit.Test;

import java.sql.Connection;

public class CustomerDaoTest {
    CustomerDao customerDao = new CustomerDao();

    @Test
    public void testGet() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            Customer customer = customerDao.get(connection, sql, 4);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null,connection);
        }
    }
}