package by.itacademy.dao.impl;

import by.itacademy.Student;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class StudentDao extends GenericDao<Student> {
    public StudentDao(final SessionFactory sessionFactory) {
        super(Student.class, DaoException.StudentDaoException::new, sessionFactory);
    }

    @Override
    public void create(Student entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Student read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Student entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
