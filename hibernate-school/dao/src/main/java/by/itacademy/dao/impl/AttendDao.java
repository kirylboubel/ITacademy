package by.itacademy.dao.impl;

import by.itacademy.Attend;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class AttendDao extends GenericDao<Attend> {
    public AttendDao(final SessionFactory sessionFactory) {
        super(Attend.class, DaoException.AttendDaoException::new, sessionFactory);
    }

    @Override
    public void create(Attend entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Attend read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Attend entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
