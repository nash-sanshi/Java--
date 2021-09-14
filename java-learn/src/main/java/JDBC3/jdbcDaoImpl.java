package src.main.java.JDBC3;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用QueryRunner提供其具体的实现
 * @param <T>：子类需传入的泛型类型
 */
public class jdbcDaoImpl<T> implements DAO<T>{
    private QueryRunner queryRunner = null;

    public jdbcDaoImpl() {
        queryRunner = new QueryRunner();
    }

    @Override
    public void update(Connection connection, String sql, Object... args) {

    }

    @Override
    public T get(Connection connection, String sql, Object... args) throws SQLException {
        return (T)queryRunner.query(connection, sql, new BeanHandler<>(Customer.class), args);

    }

    @Override
    public List<T> getForList(Connection connection, String sql, Object... args) {
        return null;
    }

    @Override
    public <E> E getForValue(Connection connection, String sql, Object... args) {
        return null;
    }

    @Override
    public void batch(Connection connection, String sql, Object[]... args) {

    }
}
