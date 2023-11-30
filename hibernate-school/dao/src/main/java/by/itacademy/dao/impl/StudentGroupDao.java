package by.itacademy.dao.impl;

import by.itacademy.StudentGroup;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class StudentGroupDao extends GenericDao<StudentGroup> {
    public StudentGroupDao(final SessionFactory sessionFactory) {
        super(StudentGroup.class, DaoException.StudentGroupDaoException::new, sessionFactory);
    }

    @Override
    public void create(StudentGroup entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public StudentGroup read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(StudentGroup entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
