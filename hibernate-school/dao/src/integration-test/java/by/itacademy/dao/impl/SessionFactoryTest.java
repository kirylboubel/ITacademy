package by.itacademy.dao.impl;

import by.itacademy.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryTest {
    protected static final SessionFactory SESSION_FACTORY = getSessionFactory();
    private static SessionFactory getSessionFactory() {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernateTestConfiguration.cfg.xml");

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
                return configuration.buildSessionFactory();
            } catch (Throwable e){
                throw new ExceptionInInitializerError(e);
            }
    }
}
