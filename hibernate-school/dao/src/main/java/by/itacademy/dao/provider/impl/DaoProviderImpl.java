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
        daoMap.put(Address.class, new AddressDao(sessionFactory));
        daoMap.put(Assessment.class, new AddressDao(sessionFactory));
        daoMap.put(Attend.class, new AddressDao(sessionFactory));
        daoMap.put(GroupRoom.class, new GroupRoomDao(sessionFactory));
        daoMap.put(Lesson.class, new LessonDao(sessionFactory));
        daoMap.put(Parent.class, new ParentDao(sessionFactory));
        daoMap.put(Schedule.class, new ScheduleDao(sessionFactory));
        daoMap.put(School.class, new SchoolDao(sessionFactory));
        daoMap.put(Student.class, new StudentDao(sessionFactory));
        daoMap.put(StudentGroup.class, new StudentDao(sessionFactory));
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
