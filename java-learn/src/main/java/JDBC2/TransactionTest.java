package src.main.java.JDBC2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    /**
     * tom给jack汇款500元
     * 关于事务
     * 1、如果多个操作，每个操作使用的是自己的单独的连接，则无法保证事务
     * 2、具体步骤：
     *      a、事务操作开始前，开始事务，取消Connection的默认提交行为，connection.setAutoCommit(false);
     *      b、如果事务的操作都成功，则提交事务，connection.commit();
     *      c、回滚事务：若出现异常，则在catch块中回滚事务
     */
    @Test
    public void test() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            System.out.println(connection.getAutoCommit());
            //开始事务：取消默认的提交
            connection.setAutoCommit(false);
            String sql = "update users set balance = balance - 500 where id = 1";
            update(connection,sql);
            //int i = 10/0;
            //System.out.println(i);
            sql = "update users set balance = balance + 500 where id = 2";
            update(connection,sql);
            //提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCTools.release(null,connection);
        }






    }

    public void update(Connection connection,String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(preparedStatement, null);
        }
    }
}
