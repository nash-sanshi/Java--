package src.main.java.JDBC3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 访问数据的DAO接口
 * 里面定义好反问数据表的各种方法
 * @param <T>：DAO处理的实体类的类型
 */
public interface DAO <T>{
    /**
     * Insert,update,delete
     * @param connection:数据库连接
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     */
    void update(Connection connection, String sql, Object... args);

    /**
     * 返回一个T的对象
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    T get(Connection connection, String sql, Object... args) throws SQLException;

    /**
     * 返回T的一个集合
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    List<T> getForList(Connection connection, String sql, Object... args);

    /**
     * 返回一个具体的值，比如总人数，平均工资，某一个name
     * @param connection
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    <E> E getForValue(Connection connection, String sql, Object... args);

    /**
     * 批处理的方法
     * @param connection
     * @param sql
     * @param args:填充占位符的Object[]类型的可变参数
     */
    void batch(Connection connection, String sql, Object[]... args);
}
