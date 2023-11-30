package by.itacademy.dao.impl;

import by.itacademy.Schedule;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class ScheduleDao extends GenericDao<Schedule> {
    public ScheduleDao(final SessionFactory sessionFactory) {
        super(Schedule.class, DaoException.ScheduleDaoException::new, sessionFactory);
    }

    @Override
    public void create(Schedule entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Schedule read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Schedule entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
