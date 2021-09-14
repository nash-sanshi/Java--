package src.main.java.JDBC3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * �������ݵ�DAO�ӿ�
 * ���涨��÷������ݱ�ĸ��ַ���
 * @param <T>��DAO�����ʵ���������
 */
public interface DAO <T>{
    /**
     * Insert,update,delete
     * @param connection:���ݿ�����
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     */
    void update(Connection connection, String sql, Object... args);

    /**
     * ����һ��T�Ķ���
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    T get(Connection connection, String sql, Object... args) throws SQLException;

    /**
     * ����T��һ������
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    List<T> getForList(Connection connection, String sql, Object... args);

    /**
     * ����һ�������ֵ��������������ƽ�����ʣ�ĳһ��name
     * @param connection
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    <E> E getForValue(Connection connection, String sql, Object... args);

    /**
     * ������ķ���
     * @param connection
     * @param sql
     * @param args:���ռλ����Object[]���͵Ŀɱ����
     */
    void batch(Connection connection, String sql, Object[]... args);
}
