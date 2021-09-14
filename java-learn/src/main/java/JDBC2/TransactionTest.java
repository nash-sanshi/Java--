package src.main.java.JDBC2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    /**
     * tom��jack���500Ԫ
     * ��������
     * 1��������������ÿ������ʹ�õ����Լ��ĵ��������ӣ����޷���֤����
     * 2�����岽�裺
     *      a�����������ʼǰ����ʼ����ȡ��Connection��Ĭ���ύ��Ϊ��connection.setAutoCommit(false);
     *      b���������Ĳ������ɹ������ύ����connection.commit();
     *      c���ع������������쳣������catch���лع�����
     */
    @Test
    public void test() {
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            System.out.println(connection.getAutoCommit());
            //��ʼ����ȡ��Ĭ�ϵ��ύ
            connection.setAutoCommit(false);
            String sql = "update users set balance = balance - 500 where id = 1";
            update(connection,sql);
            //int i = 10/0;
            //System.out.println(i);
            sql = "update users set balance = balance + 500 where id = 2";
            update(connection,sql);
            //�ύ����
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //�ع�����
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
