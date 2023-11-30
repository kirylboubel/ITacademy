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

    @Override
    public void create(Address entity) throws DaoException {
        super.create(entity);
    }

    @Override
    public Address read(Integer id) throws DaoException {
        return super.read(id);
    }

    @Override
    public void update(Address entity) throws DaoException {
        super.update(entity);
    }

    @Override
    public void delete(Integer id) throws DaoException {
        super.delete(id);
    }
}
