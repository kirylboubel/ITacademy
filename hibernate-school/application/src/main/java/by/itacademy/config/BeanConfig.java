package by.itacademy.config;

import by.itacademy.Assessment;
import by.itacademy.Student;
import by.itacademy.Subject;
import by.itacademy.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.itacademy"})
public class BeanConfig {
    @Autowired
    private static SessionFactory sessionFactory;

    @Bean
    public static SessionFactory getSessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Assessment.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Subject.class)
                .addAnnotatedClass(Teacher.class);

        return sessionFactory = configuration.buildSessionFactory();
    }
}
