package by.itacademy.dao.impl;

import by.itacademy.GroupRoom;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class GroupRoomDao extends GenericDao<GroupRoom> {
    public GroupRoomDao(final SessionFactory sessionFactory) {
        super(GroupRoom.class, DaoException.GroupRoomDaoException::new, sessionFactory);
    }

    @Override
    public void create(GroupRoom entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public GroupRoom read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(GroupRoom entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
