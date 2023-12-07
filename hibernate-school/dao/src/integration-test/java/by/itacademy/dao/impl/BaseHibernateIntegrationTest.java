package by.itacademy.dao.impl;

import by.itacademy.*;
import by.itacademy.sessionfactory.SessionFactoryUtilException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseHibernateIntegrationTest {
    protected static final SessionFactory SESSION_FACTORY = getSessionFactory();

    private static SessionFactory getSessionFactory() {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Address.class)
                        .addAnnotatedClass(StudentGroupSubjectLink.class)
                        .addAnnotatedClass(Assessment.class)
                        .addAnnotatedClass(Attend.class)
                        .addAnnotatedClass(StudentGroup.class)
                        .addAnnotatedClass(GroupRoom.class)
                        .addAnnotatedClass(Lesson.class)
                        .addAnnotatedClass(Parent.class)
                        .addAnnotatedClass(Schedule.class)
                        .addAnnotatedClass(School.class)
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Subject.class)
                        .addAnnotatedClass(Teacher.class);
                configuration.configure("hibernateTestConfiguration.cfg.xml");
                final SessionFactory sessionFactory = configuration.buildSessionFactory();
                return sessionFactory;
            } catch (Throwable e){
                throw new ExceptionInInitializerError(e);
            }
    }
}
