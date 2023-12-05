package by.itacademy.dao.impl;

import by.itacademy.GroupRoom;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import org.hibernate.SessionFactory;

public class GroupRoomDao extends GenericDao<GroupRoom> {
    public GroupRoomDao(final SessionFactory sessionFactory) {
        super(GroupRoom.class, DaoException.GroupRoomDaoException::new, sessionFactory);
    }
}
