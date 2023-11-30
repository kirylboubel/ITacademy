package by.itacademy.dao.provider;

import by.itacademy.dao.GenericDao;

public interface DaoProvider {

    <T> GenericDao<T> provide(Class<T> entityClass) ;
}
