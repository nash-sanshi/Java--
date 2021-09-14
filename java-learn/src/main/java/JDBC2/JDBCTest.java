package src.main.java.JDBC2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class JDBCTest {
    /**
     * 取得数据库自动生成的主键
     */
    @Test
    public void testGetKeyValue() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            //preparedStatement = connection.prepareStatement(sql);
            //使用重载的prepareStatement(sql,flag)来生成prepareStatement对象
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,"ABCD");
            preparedStatement.setString(2,"ABCD@qq.com");
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
            //通过getGeneratedKeys()获取包含新生成的主键的ResultSet对象
            //在ResultSet中只有一列Generated_key，用于存放新生成的主键值
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
     * 插入Blob类型的数据必须使用PreparedStatement
     * 因为Blob类型的数据无法使用字符串拼写
     * 调用setBlob(int index,inputStream)
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
     * 读取Blob数据
     * 1、使用getBlob方法读取Blob对象
     * 2、调用Blob的getBinaryStream()方法得到输入流，然后再使用IO操作
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
