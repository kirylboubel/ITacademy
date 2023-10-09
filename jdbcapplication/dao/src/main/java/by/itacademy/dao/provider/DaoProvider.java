package by.itacademy.dao.provider;

import by.itacademy.dao.mapper.model.BaseModel;
import by.itacademy.dao.Dao;

public interface DaoProvider {
    <E extends BaseModel, D extends Dao<E>> D provide(Class<E> entityClass);
}
