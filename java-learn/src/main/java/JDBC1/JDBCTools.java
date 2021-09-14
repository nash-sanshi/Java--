package src.main.java.JDBC1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ����JDBC�Ĺ����࣬���з�װ��һЩ���߷���
 */

public class JDBCTools {
    /**
     * 1����ȡ���ӵķ���
     * ͨ�������ļ������ݿ��������ȡһ������
     */
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //1��׼���������ݿ��4���ַ���
        //a������Properties����
        Properties properties = new Properties();
        //b����ȡjdbc.properties��Ӧ��������
        InputStream inputStream = JDBCTools.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inputStream);
        String driverClass = properties.getProperty("driver");
        String JdbcUrl = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //2����������
        Class.forName(driverClass);
        //3��ͨ��DriverManager��getConnection������ȡ���ݿ�����
        return DriverManager.getConnection(JdbcUrl,user,password);
    }

    /**
     * �ر�Statement��Connection
     */
    public static void release(Statement statement, Connection connection) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    public static void release(ResultSet resultSet,Statement statement, Connection connection) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    /**
     * ͨ�õĸ��·���������insert��update��delete
     * �汾1.0
     */
    public static void update(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCTools.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(statement,connection);
        }
    }

    public static void update(String sql, Object... args) {
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
}