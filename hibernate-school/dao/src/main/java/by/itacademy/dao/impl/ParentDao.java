package by.itacademy.dao.impl;

import by.itacademy.Parent;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class ParentDao extends GenericDao<Parent> {
    public ParentDao(final SessionFactory sessionFactory) {
        super(Parent.class, DaoException.ParentDaoException::new, sessionFactory);
    }
}
