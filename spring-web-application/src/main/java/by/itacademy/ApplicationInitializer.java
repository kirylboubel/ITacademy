package by.itacademy;

import by.itacademy.config.ContextConfiguration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final var webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(ContextConfiguration.class);
        webContext.setServletContext(servletContext);

        final var dispatcherServlet = new DispatcherServlet(webContext);
        final var servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
