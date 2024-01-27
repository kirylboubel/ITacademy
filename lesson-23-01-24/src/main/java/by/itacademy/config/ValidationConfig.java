package by.itacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ValidationConfig {
    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public static MethodValidationPostProcessor validationPostProcessor(){
        final var processor = new MethodValidationPostProcessor();
        processor.setAdaptConstraintViolations(true);
        return processor;
    }
}
