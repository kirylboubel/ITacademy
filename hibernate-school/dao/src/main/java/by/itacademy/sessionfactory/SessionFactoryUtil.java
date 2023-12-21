package by.itacademy.sessionfactory;

import by.itacademy.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private SessionFactoryUtil(){}

    public static SessionFactory getSessionFactory() throws SessionFactoryUtilException {
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

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

                sessionFactory = configuration.buildSessionFactory();
            } catch (final HibernateException e){
                throw new SessionFactoryUtilException("Failed to create SessionFactory", e);
            }

        }
        return sessionFactory;
    }
}
