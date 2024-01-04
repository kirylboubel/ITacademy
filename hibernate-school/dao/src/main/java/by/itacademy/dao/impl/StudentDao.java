package by.itacademy.dao.impl;

import by.itacademy.Student;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentDao extends GenericDao<Student> {
    @Autowired
    public StudentDao(final SessionFactory sessionFactory) {
        super(Student.class, DaoException.StudentDaoException::new, sessionFactory);
    }
}
