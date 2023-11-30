package by.itacademy.dao.impl;

import by.itacademy.School;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class SchoolDao extends GenericDao<School> {
    public SchoolDao(final SessionFactory sessionFactory) {
        super(School.class, DaoException.ScheduleDaoException::new, sessionFactory);
    }

    @Override
    public void create(School entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public School read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(School entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
