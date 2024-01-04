package by.itacademy.dao.impl;

import by.itacademy.Assessment;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentDao extends GenericDao<Assessment> {
    @Autowired
    public AssessmentDao(final SessionFactory sessionFactory) {
        super(Assessment.class, DaoException.AssessmentDaoException::new, sessionFactory);
    }
}
