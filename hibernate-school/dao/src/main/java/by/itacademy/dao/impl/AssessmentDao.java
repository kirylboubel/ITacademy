package by.itacademy.dao.impl;

import by.itacademy.Assessment;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class AssessmentDao extends GenericDao<Assessment> {
    public AssessmentDao(final SessionFactory sessionFactory) {
        super(Assessment.class, DaoException.AddressDaoException::new, sessionFactory);
    }

    @Override
    public void create(Assessment entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Assessment read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Assessment entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
