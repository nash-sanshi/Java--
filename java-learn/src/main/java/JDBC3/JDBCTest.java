package src.main.java.JDBC3;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCTest {
    /**
     * 向Oracle的customers数据表中插入10万条记录
     * 测试如何插入，用时长短
     * 1、使用Statement；
     */
    @Test
    public void testBatchWithStatement() {
        Connection connection = null;
        Statement statement = null;
        String sql = null;
        try {
            connection = JDBCTools.getConnection();
            //System.out.println(connection);
            JDBCTools.beginTx(connection);
            statement = connection.createStatement();
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                sql = "insert into customers values(" + (i + 1) + ",'name_" + i + "','12-9月-21')";
                statement.executeUpdate(sql);
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin));//52s Statement
            JDBCTools.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            JDBCTools.rollback(connection);
        } finally {
            JDBCTools.release(statement,connection);
        }
    }

    @Test
    public void testBatchWithPreparedStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = null;
        try {
            connection = JDBCTools.getConnection();
            //System.out.println(connection);
            JDBCTools.beginTx(connection);
            sql = "insert into customers values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            Date date = new Date(new java.util.Date().getTime());
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "name_" + i);
                preparedStatement.setDate(3, date);
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin));//13s PreparedStatement
            JDBCTools.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            JDBCTools.rollback(connection);
        } finally {
            JDBCTools.release(preparedStatement,connection);
        }
    }

    @Test
    public void testBatch() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = null;
        try {
            connection = JDBCTools.getConnection();
            //System.out.println(connection);
            JDBCTools.beginTx(connection);
            sql = "insert into customers values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            Date date = new Date(new java.util.Date().getTime());
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "name_" + i);
                preparedStatement.setDate(3, date);
                //积累SQL
                preparedStatement.addBatch();
                //当积累到一定程度，就统一的执行一次，并且清空先前积累的SQL
                if ((i + 1) % 300 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            //若总条数不是批量数值的整数倍，则还需要在额外的执行一次
            if (100000 % 300 != 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin));//1s Batch
            JDBCTools.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            JDBCTools.rollback(connection);
        } finally {
            JDBCTools.release(preparedStatement,connection);
        }
    }

    /**
     *使用DBCP数据库连接池
     * 1、加入开源jar包
     * 2、创建数据库连接池
     * 3、为数据源实例指定可选的属性
     * 4、从数据源中获取数据库连接
     */
    @Test
    public void testDBCP() throws SQLException {
        //1、创建DBCP数据源实例
        BasicDataSource dataSource = new BasicDataSource();
        //2、为数据源实例指定必须的属性
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //3、为数据源实例指定可选的属性
        //a、指定数据库连接池中初始化连接数的个数
        dataSource.setInitialSize(5);
        //b、指定最大的链接数：同一个时刻可以同时向数据库申请的连接数
        dataSource.setMaxActive(5);
        //c、指定最小的连接数：在数据库连接池中保存的最小的空闲连接的数量
        dataSource.setMinIdle(2);
        //d、等到数据库连接池分配连接的最长时间，单位为毫秒，超出改时间将抛出异常
        dataSource.setMaxWait(1000 * 5);
        //4、从数据源中获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 1、加在DBCP的properties配置文件：配置文件中的键需要来自BasicDataSource的属性
     * 2、调用BasicDataSourceFactory的createDataSource方法创建DataSource实例
     * 3、从DataSource实例中获取数据库连接
     * @throws Exception
     */
    @Test
    public void testDBCPWithDataSourceFactory() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = JDBCTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        properties.load(inputStream);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testC3P0() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useSSL=false" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        System.out.println(cpds.getConnection());
    }

    /**
     * 1、创建c3p0-config.xml文件
     * 参考帮助文档中12.III内容
     * 2、创建ComboPooledDataSource实例
     * 3、从DataSource实例中获取数据库连接
     * @throws SQLException
     */
    @Test
    public void testC3P0WithConfigFile() throws SQLException {
        //2、创建ComboPooledDataSource实例
        DataSource dataSource = new ComboPooledDataSource("helloc3p0");
        System.out.println(dataSource.getConnection());
        //3、从DataSource实例中获取数据库连接
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
        System.out.println(comboPooledDataSource.getMaxStatements());
    }

    @Test
    public void testJdbcTools() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCTools.getConnection();
        System.out.println(connection);
    }
}
