package by.itacademy.dao;

import org.springframework.stereotype.Service;


public interface Dao<T> {
    void  create(T entity) throws DaoException;

    T read(Integer id) throws DaoException;

    void update (T entity) throws DaoException;

    void delete (Integer id) throws DaoException;
}
