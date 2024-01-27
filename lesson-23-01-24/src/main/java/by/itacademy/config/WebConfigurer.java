package by.itacademy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    private final LocalValidatorFactoryBean validatorFactoryBean;
    private final ObjectMapper objectMapper;

    @Autowired
    public WebConfigurer(
            final LocalValidatorFactoryBean validatorFactoryBean,
            final ObjectMapper objectMapper
    ) {
        this.validatorFactoryBean = validatorFactoryBean;
        this.objectMapper = objectMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        converters.add(new ObjectToStringHttpMessageConverter(new DefaultConversionService()));
    }

    @Override
    public Validator getValidator() {
        return validatorFactoryBean;
    }
}
