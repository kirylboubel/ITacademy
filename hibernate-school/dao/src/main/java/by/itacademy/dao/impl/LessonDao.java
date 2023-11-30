package by.itacademy.dao.impl;

import by.itacademy.Lesson;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class LessonDao extends GenericDao<Lesson> {
    public LessonDao(final SessionFactory sessionFactory) {
        super(Lesson.class, DaoException.LessonDaoException::new, sessionFactory);
    }

    @Override
    public void create(Lesson entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Lesson read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Lesson entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
