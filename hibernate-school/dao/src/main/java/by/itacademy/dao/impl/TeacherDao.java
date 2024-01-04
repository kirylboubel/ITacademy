package by.itacademy.dao.impl;

import by.itacademy.Teacher;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherDao extends GenericDao<Teacher> {
    @Autowired
    public TeacherDao(final SessionFactory sessionFactory) {
        super(Teacher.class, DaoException.TeacherDaoException::new, sessionFactory);
    }
}
