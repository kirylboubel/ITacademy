package by.itacademy.dao.provider;

import by.itacademy.dao.Dao;
import by.itacademy.entity.Person;

public interface DaoProvider {
    <E extends Person, D extends Dao<E>> D provide(Class<E> entityClass);
}
