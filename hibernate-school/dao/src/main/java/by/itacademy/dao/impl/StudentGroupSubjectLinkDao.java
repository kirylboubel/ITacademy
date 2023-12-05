package by.itacademy.dao.impl;

import by.itacademy.StudentGroupSubjectLink;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

import java.util.function.BiFunction;

public class StudentGroupSubjectLinkDao extends GenericDao<StudentGroupSubjectLink> {
    public StudentGroupSubjectLinkDao(final  SessionFactory sessionFactory) {
        super(StudentGroupSubjectLink.class, DaoException.StudentGroupSubjectLinkException::new, sessionFactory);
    }
}
