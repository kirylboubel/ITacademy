package by.itacademy.dao.impl;

import by.itacademy.Teacher;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class TeacherDao extends GenericDao<Teacher> {
    public TeacherDao(final SessionFactory sessionFactory) {
        super(Teacher.class, DaoException.TeacherDaoException::new, sessionFactory);
    }

    @Override
    public void create(Teacher entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Teacher read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Teacher entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
