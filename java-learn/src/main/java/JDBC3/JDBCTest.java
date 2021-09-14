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
     * ��Oracle��customers���ݱ��в���10������¼
     * ������β��룬��ʱ����
     * 1��ʹ��Statement��
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
                sql = "insert into customers values(" + (i + 1) + ",'name_" + i + "','12-9��-21')";
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
                //����SQL
                preparedStatement.addBatch();
                //�����۵�һ���̶ȣ���ͳһ��ִ��һ�Σ����������ǰ���۵�SQL
                if ((i + 1) % 300 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            //������������������ֵ��������������Ҫ�ڶ����ִ��һ��
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
     *ʹ��DBCP���ݿ����ӳ�
     * 1�����뿪Դjar��
     * 2���������ݿ����ӳ�
     * 3��Ϊ����Դʵ��ָ����ѡ������
     * 4��������Դ�л�ȡ���ݿ�����
     */
    @Test
    public void testDBCP() throws SQLException {
        //1������DBCP����Դʵ��
        BasicDataSource dataSource = new BasicDataSource();
        //2��Ϊ����Դʵ��ָ�����������
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //3��Ϊ����Դʵ��ָ����ѡ������
        //a��ָ�����ݿ����ӳ��г�ʼ���������ĸ���
        dataSource.setInitialSize(5);
        //b��ָ��������������ͬһ��ʱ�̿���ͬʱ�����ݿ������������
        dataSource.setMaxActive(5);
        //c��ָ����С���������������ݿ����ӳ��б������С�Ŀ������ӵ�����
        dataSource.setMinIdle(2);
        //d���ȵ����ݿ����ӳط������ӵ��ʱ�䣬��λΪ���룬������ʱ�佫�׳��쳣
        dataSource.setMaxWait(1000 * 5);
        //4��������Դ�л�ȡ���ݿ�����
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 1������DBCP��properties�����ļ��������ļ��еļ���Ҫ����BasicDataSource������
     * 2������BasicDataSourceFactory��createDataSource��������DataSourceʵ��
     * 3����DataSourceʵ���л�ȡ���ݿ�����
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
     * 1������c3p0-config.xml�ļ�
     * �ο������ĵ���12.III����
     * 2������ComboPooledDataSourceʵ��
     * 3����DataSourceʵ���л�ȡ���ݿ�����
     * @throws SQLException
     */
    @Test
    public void testC3P0WithConfigFile() throws SQLException {
        //2������ComboPooledDataSourceʵ��
        DataSource dataSource = new ComboPooledDataSource("helloc3p0");
        System.out.println(dataSource.getConnection());
        //3����DataSourceʵ���л�ȡ���ݿ�����
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
        System.out.println(comboPooledDataSource.getMaxStatements());
    }

    @Test
    public void testJdbcTools() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCTools.getConnection();
        System.out.println(connection);
    }
}
