package by.itacademy.dao;

import by.itacademy.jdbc.JdbcDaoException;

public interface Dao<T> {
    Integer create(T person) throws DaoException, JdbcDaoException;

    T read(Integer id) throws DaoException, JdbcDaoException;
}
