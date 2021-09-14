package src.main.java.JDBC2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class JDBCTest {
    /**
     * ȡ�����ݿ��Զ����ɵ�����
     */
    @Test
    public void testGetKeyValue() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            //preparedStatement = connection.prepareStatement(sql);
            //ʹ�����ص�prepareStatement(sql,flag)������prepareStatement����
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,"ABCD");
            preparedStatement.setString(2,"ABCD@qq.com");
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
            //ͨ��getGeneratedKeys()��ȡ���������ɵ�������ResultSet����
            //��ResultSet��ֻ��һ��Generated_key�����ڴ�������ɵ�����ֵ
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println(resultSet.getObject(1));
            }
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                System.out.println(resultSetMetaData.getColumnName(i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(preparedStatement,connection);
        }
    }

    /**
     * ����Blob���͵����ݱ���ʹ��PreparedStatement
     * ��ΪBlob���͵������޷�ʹ���ַ���ƴд
     * ����setBlob(int index,inputStream)
     */
    @Test
    public void testInsertBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into customers(name,email,birth,picture) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "aaaa");
            preparedStatement.setString(2, "aaaa@qq.com");
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            InputStream inputStream = new FileInputStream("1.jpg");
            preparedStatement.setBlob(4, inputStream);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(preparedStatement,connection);
        }
    }

    /**
     * ��ȡBlob����
     * 1��ʹ��getBlob������ȡBlob����
     * 2������Blob��getBinaryStream()�����õ���������Ȼ����ʹ��IO����
     */
    @Test
    public void readBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select id,name,email,birth,picture from customers where id = 9";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                System.out.println(id + "," + name + "," + email + "," + date);
                Blob p = resultSet.getBlob(5);
                InputStream inputStream = p.getBinaryStream();
                System.out.println(inputStream.available());
                OutputStream outputStream = new FileOutputStream("2.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while (-1 != (len = inputStream.read(bytes))) {
                    outputStream.write(bytes, 0, len);
                }
                inputStream.close();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet, preparedStatement, connection);
        }
    }
}
