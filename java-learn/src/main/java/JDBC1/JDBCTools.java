package src.main.java.JDBC1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作JDBC的工具类，其中封装了一些工具方法
 */

public class JDBCTools {
    /**
     * 1、获取连接的方法
     * 通过配置文件从数据库服务器获取一个连接
     */
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //1、准备连接数据库的4个字符串
        //a、创建Properties对象
        Properties properties = new Properties();
        //b、获取jdbc.properties对应的输入流
        InputStream inputStream = JDBCTools.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inputStream);
        String driverClass = properties.getProperty("driver");
        String JdbcUrl = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //2、加载驱动
        Class.forName(driverClass);
        //3、通过DriverManager的getConnection方法获取数据库连接
        return DriverManager.getConnection(JdbcUrl,user,password);
    }

    /**
     * 关闭Statement和Connection
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
     * 通用的更新方法，包括insert，update，delete
     * 版本1.0
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