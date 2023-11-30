package by.itacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class GenericDao<T> implements Dao<T> {

    private final Class<T> type;
    private final BiFunction<String, Exception, DaoException> exceptionCreator;
    private final SessionFactory sessionFactory;

    public GenericDao(
            Class<T> type,
            BiFunction<String, Exception, DaoException> exceptionCreator,
            SessionFactory sessionFactory
    ) {
        this.type = type;
        this.exceptionCreator = exceptionCreator;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(final T entity) throws DaoException {
        perform((session) -> session.merge(entity), "Failed to create entity: " + type);
    }


    @Override
    public T read(final Integer id) throws DaoException {
        return perform((session -> session.find(type, id)), "Failed to read entity " + type);
    }

    @Override
    public void update(final T entity) throws DaoException {
        perform((session) -> session.merge(entity), "Failed to update entity: " + type);
    }

    @Override
    public void delete(final Integer id) throws DaoException {
        perform((session) -> {
            T entity = session.find(type, id);
            session.remove(entity);
            return entity;
        }, "Failed to delete entity: " + type);
    }

    protected final Session getSession() {
        return sessionFactory.openSession();
    }

    protected T perform(final Function<Session, T> function, final String errorMessage) throws DaoException {
        Transaction transaction = null;
        T result;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            result = function.apply(session);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (RuntimeException rex) {
                throw exceptionCreator.apply("Failed to rollback for: " + type, rex);
            }
            throw exceptionCreator.apply(errorMessage, e);
        }
    }
}
