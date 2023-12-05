package by.itacademy.dao.impl;

import by.itacademy.Address;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.GenericDao;
import by.itacademy.sessionfactory.SessionFactoryUtil;
import org.hibernate.SessionFactory;

public class AddressDao extends GenericDao<Address> {

    public AddressDao(final SessionFactory sessionFactory){
        super(Address.class, DaoException.AddressDaoException::new ,sessionFactory);
    }

}
