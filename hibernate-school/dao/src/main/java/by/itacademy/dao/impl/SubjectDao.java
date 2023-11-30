package by.itacademy.dao.impl;

import by.itacademy.Subject;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class SubjectDao extends GenericDao<Subject> {
    public SubjectDao(final SessionFactory sessionFactory) {
        super(Subject.class, DaoException.SubjectDaoException::new, sessionFactory);
    }

    @Override
    public void create(Subject entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Subject read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Subject entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
