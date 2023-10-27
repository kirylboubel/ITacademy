package by.itacademy.jdbc.provider;

import by.itacademy.dao.Dao;
import by.itacademy.dao.provider.DaoProvider;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.entity.Person;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.impl.PersonJdbcDao;
import by.itacademy.jdbc.mapper.impl.PeronResulSetMapper;

import java.util.HashMap;
import java.util.Map;

public class JdbcDaoProvider implements DaoProvider {
    private final Map<Class<? extends Person>, Dao<? extends Person>> map;
    private final JdbcDataSourceProperties properties;

    public JdbcDaoProvider(final JdbcDataSourceProperties properties) throws JdbcDaoException {
        this.properties = properties;
        this.map = new HashMap<>();

        map.put(Person.class, new PersonJdbcDao(properties, new PeronResulSetMapper()));
    }

    @Override
    public <E extends Person, D extends Dao<E>> D provide(Class<E> entityClass) {
        return (D) map.get(entityClass);
    }
}
