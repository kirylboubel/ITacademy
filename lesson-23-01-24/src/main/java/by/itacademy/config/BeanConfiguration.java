package by.itacademy.config;

import by.itacademy.entity.Assessment;
import by.itacademy.entity.Student;
import by.itacademy.entity.Subject;
import by.itacademy.entity.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "by.itacademy")
@PropertySource("classpath:application.properties")
public class BeanConfiguration {

}
