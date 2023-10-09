package by.itacademy.dao.jdbc.impl;

import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;
import by.itacademy.dao.jdbc.GenericJdbcDao;
import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.client.Client;

import java.sql.*;

public class ClientJdbcDao extends GenericJdbcDao<Client> {
    private final ResultSetMapper<Client> mapper;

    public ClientJdbcDao(final JdbcDataSourceProperties properties, final ResultSetMapper<Client> mapper) throws DaoException {
        super(properties, "client", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPrepareStatementForCreate(final Connection cn, final Client client) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into client (first_name, last_name) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, client.getFirstName());
        ps.setString(2, client.getLastName());
        return ps;
    }

    @Override
    protected Client mapReadResult(final ResultSet resultSet) throws SQLException {
        try {
            return mapper.map(resultSet);
        } catch (ResultSetMapperException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer create(final Client model) throws DaoException {
        return super.create(model);
    }

    @Override
    public Client read(final Integer id) throws DaoException {
        return super.read(id);
    }
}
