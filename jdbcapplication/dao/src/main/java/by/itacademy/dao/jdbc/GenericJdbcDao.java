package by.itacademy.dao.jdbc;

import by.itacademy.dao.Dao;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;
import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;

import java.sql.*;

public abstract class GenericJdbcDao<T> implements Dao<T> {
    private final JdbcDataSourceProperties properties;
    private final String tableName;
    private final ResultSetMapper<T> mapper;

    public GenericJdbcDao(
            final JdbcDataSourceProperties properties,
            final String tableName,
            final ResultSetMapper<T> mapper
    ) throws DaoException {
        this.properties = properties;
        this.tableName = tableName;
        this.mapper = mapper;

        registerDriver(properties.getDriver());
    }

    protected abstract PreparedStatement getPrepareStatementForCreate(final Connection cn, final T model) throws SQLException;

    protected abstract T mapReadResult(final ResultSet resultSet) throws SQLException, ResultSetMapperException;

    @Override
    public Integer create(final T model) throws DaoException {
        try (final Connection connection = createConnection()) {
            final PreparedStatement ps = getPrepareStatementForCreate(connection, model);
            ps.executeUpdate();

            final ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new DaoException("Failed to retrieve id", null);
        } catch (final Exception e) {
            throw new DaoException("Failed to create transport", e);
        }
    }

    @Override
    public T read(final Integer id) throws DaoException {
        try (final Connection connection = createConnection()) {
            final String readSql = "select * from %s where id= ?".formatted(tableName);

            final PreparedStatement ps = connection.prepareStatement(readSql);
            ps.setInt(1, id);

            final ResultSet rs = ps.executeQuery();
            return mapper.map(rs);
        } catch (final Exception e) {
            throw new DaoException("Failed to read: " + tableName, e);
        }
    }

    private Connection createConnection() throws DaoException, SQLException {
        return DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());
    }

    private static void registerDriver(final String driverName) throws DaoException {
        try {

            final Class<?> driverClass = Class.forName(driverName);

            final boolean isNotRegistered = DriverManager.drivers().noneMatch(dr -> dr.getClass().equals(driverName));
            if (isNotRegistered) {
                final Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
                DriverManager.registerDriver(driver);
            }

        } catch (final Exception e) {
            throw new DaoException("Failed to register driver: " + driverName, e);
        }
    }
}
