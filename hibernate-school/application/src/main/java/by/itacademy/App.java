package by.itacademy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Assessment.class);
        configuration.addAnnotatedClass(Attend.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(GroupRoom.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Parent.class);
        configuration.addAnnotatedClass(Schedule.class);
        configuration.addAnnotatedClass(School.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Subject.class);
        configuration.addAnnotatedClass(Teacher.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<Subject> subjects = session.createQuery("from Subject", Subject.class).list();
            System.out.println("subjects = " + subjects);

            session.getTransaction().commit();
        }
    }
}
