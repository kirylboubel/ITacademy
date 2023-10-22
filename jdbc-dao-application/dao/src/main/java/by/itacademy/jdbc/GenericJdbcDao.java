package by.itacademy.jdbc;

import by.itacademy.Dao;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import org.postgresql.Driver;

import java.sql.*;

public abstract class GenericJdbcDao<T> implements Dao<T> {
    private final JdbcDataSourceProperties properties;
    private final String tableName;
    private final ResultSetMapper<T> mapper;

    public GenericJdbcDao(
            final JdbcDataSourceProperties properties,
            final String tableName,
            final ResultSetMapper<T> mapper
    ) throws JdbcDaoException {
        this.properties = properties;
        this.tableName = tableName;
        this.mapper = mapper;

        registerDriver(properties.getDriver());
    }

    protected abstract PreparedStatement getPreparedStatementForCreate(final Connection cn, final T model) throws SQLException;
    protected abstract T mapReaResult (final ResultSet resultSet) throws ResultSetMapperException;

    @Override
    public Integer create(final T model) throws JdbcDaoException {
        try (final Connection connection = createConnection()) {
            final PreparedStatement ps = getPreparedStatementForCreate(connection, model);
            ps.executeUpdate();

            final ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new JdbcDaoException("Failed to retrieve id", null);
        } catch (final Exception e) {
            throw new JdbcDaoException("Failed to create model", e);
        }
    }

    @Override
    public T read(Integer id) throws JdbcDaoException {
        try (final Connection connection = createConnection()) {
            final String readSql = "select * from %s where id= ?".formatted(tableName);

            final PreparedStatement ps = connection.prepareStatement(readSql);
            ps.setInt(1, id);

            final ResultSet rs = ps.executeQuery();
            return mapper.map(rs);
        } catch (final Exception e) {
            throw new JdbcDaoException("Failed to read: " + tableName, e);
        }
    }

    private Connection createConnection() throws JdbcDaoException {
        try {
            return DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());
        } catch (final SQLException e) {
            throw new JdbcDaoException("Failed to create connection ", e);
        }
    }

    private static void registerDriver(final String driverName) throws JdbcDaoException {
        try {

            final Class<?> driverClass = Class.forName(driverName);

            final boolean isNotRegistered = DriverManager.drivers().noneMatch(dr -> dr.getClass().equals(driverClass));
            if (isNotRegistered) {
                final Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
                DriverManager.registerDriver(driver);
            }
        } catch (final Exception e) {
            throw new JdbcDaoException("Failed to register driver: " + driverName, e);
        }
    }
}
