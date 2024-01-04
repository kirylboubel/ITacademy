package by.itacademy.sessionfactory;

import by.itacademy.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private SessionFactoryUtil(){}

    public static SessionFactory getSessionFactory() throws SessionFactoryUtilException {
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

                configuration.addAnnotatedClass(Assessment.class)
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Subject.class)
                        .addAnnotatedClass(Teacher.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (final HibernateException e){
                throw new SessionFactoryUtilException("Failed to create SessionFactory", e);
            }

        }
        return sessionFactory;
    }
}
