package by.itacademy;

import by.itacademy.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopApplication {
    public static void main(String[] args) {
        final var context = new AnnotationConfigApplicationContext(BeanConfig.class);
        final var application = context.getBean(ServiceApplication.class);
        application.runApp();
    }
}
