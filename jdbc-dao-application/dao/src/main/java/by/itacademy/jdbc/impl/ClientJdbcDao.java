package by.itacademy.jdbc.impl;

import by.itacademy.client.Client;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.jdbc.GenericJdbcDao;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;

import java.sql.*;

public class ClientJdbcDao extends GenericJdbcDao<Client> {
    private final ResultSetMapper<Client> mapper;

    public ClientJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<Client> mapper
    ) throws JdbcDaoException {
        super(properties, "client", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPreparedStatementForCreate(final Connection cn, final Client client) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into client (first_name, last_name) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, client.getFirstName());
        ps.setString(2, client.getLastName());
        return ps;
    }

    @Override
    protected Client mapReaResult(final ResultSet resultSet) throws ResultSetMapperException {
        return mapper.map(resultSet);
    }

    @Override
    public Integer create(Client model) throws JdbcDaoException {
        return super.create(model);
    }

    @Override
    public Client read(Integer id) throws JdbcDaoException {
        return super.read(id);
    }
}
