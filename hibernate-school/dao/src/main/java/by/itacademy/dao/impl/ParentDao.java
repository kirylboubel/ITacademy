package by.itacademy.dao.impl;

import by.itacademy.Parent;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class ParentDao extends GenericDao<Parent> {
    public ParentDao(final SessionFactory sessionFactory) {
        super(Parent.class, DaoException.ParentDaoException::new, sessionFactory);
    }

    @Override
    public void create(Parent entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Parent read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Parent entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
