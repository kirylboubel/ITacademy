package by.itacademy.jdbc.impl;

import by.itacademy.client.Client;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.entity.Person;
import by.itacademy.jdbc.GenericJdbcDao;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;

import java.sql.*;

public class PersonJdbcDao extends GenericJdbcDao<Person> {
    private final ResultSetMapper<Person> mapper;

    public PersonJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<Person> mapper
    ) throws JdbcDaoException {
        super(properties, "person", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPreparedStatementForCreate(final Connection cn, final Person person) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into person (name) values (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, person.getName());
        return ps;
    }

    @Override
    protected Person mapReaResult(final ResultSet resultSet) throws ResultSetMapperException {
        return mapper.map(resultSet);
    }

    @Override
    public Integer create(Person person) throws JdbcDaoException {
        return super.create(person);
    }

    @Override
    public Person read(Integer id) throws JdbcDaoException {
        return super.read(id);
    }
}
