package by.itacademy.dao.provider.impl;

import by.itacademy.*;
import by.itacademy.dao.GenericDao;
import by.itacademy.dao.impl.*;
import by.itacademy.dao.provider.DaoProvider;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;

public class DaoProviderImpl implements DaoProvider {
    private final Map<Class<?>, GenericDao<?>> daoMap;

    public DaoProviderImpl(final SessionFactory sessionFactory) {
        this.daoMap = new HashMap<>();
        daoMap.put(Assessment.class, new AssessmentDao(sessionFactory));
        daoMap.put(Student.class, new StudentDao(sessionFactory));
        daoMap.put(Subject.class, new SubjectDao(sessionFactory));
        daoMap.put(Teacher.class, new TeacherDao(sessionFactory));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> GenericDao<T> provide(final Class<T> entityClass) {
        GenericDao<T> dao = (GenericDao<T>) daoMap.get(entityClass);
        if (dao != null) {
            return dao;
        }
        throw new IllegalArgumentException("Dao for entity class " + entityClass + " does not exist");
    }
}
