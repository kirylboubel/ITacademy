package by.itacademy.dao.impl;

import by.itacademy.Student;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class StudentDao extends GenericDao<Student> {
    public StudentDao(final SessionFactory sessionFactory) {
        super(Student.class, DaoException.StudentDaoException::new, sessionFactory);
    }
}
