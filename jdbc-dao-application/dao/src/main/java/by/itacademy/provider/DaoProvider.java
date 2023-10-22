package by.itacademy.provider;

import by.itacademy.BaseModel;
import by.itacademy.Dao;

public interface DaoProvider {
    <E extends BaseModel, D extends Dao<E>> D provide(Class<E> entityClass);
}
