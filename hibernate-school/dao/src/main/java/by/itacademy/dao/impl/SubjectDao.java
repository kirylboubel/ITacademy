package by.itacademy.dao.impl;

import by.itacademy.Subject;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectDao extends GenericDao<Subject> {
    @Autowired
    public SubjectDao(final SessionFactory sessionFactory) {
        super(Subject.class, DaoException.SubjectDaoException::new, sessionFactory);
    }
}
