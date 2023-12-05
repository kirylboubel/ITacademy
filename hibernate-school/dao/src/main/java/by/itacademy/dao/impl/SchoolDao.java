package by.itacademy.dao.impl;

import by.itacademy.School;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class SchoolDao extends GenericDao<School> {
    public SchoolDao(final SessionFactory sessionFactory) {
        super(School.class, DaoException.ScheduleDaoException::new, sessionFactory);
    }
}
