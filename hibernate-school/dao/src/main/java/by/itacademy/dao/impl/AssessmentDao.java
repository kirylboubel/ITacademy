package by.itacademy.dao.impl;

import by.itacademy.Assessment;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class AssessmentDao extends GenericDao<Assessment> {
    public AssessmentDao(final SessionFactory sessionFactory) {
        super(Assessment.class, DaoException.AddressDaoException::new, sessionFactory);
    }
}
