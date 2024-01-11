package by.itacademy;

import by.itacademy.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplication {
    private final Service service;

    @Autowired
    public ServiceApplication(final Service service) {
        this.service = service;
    }

    public void runApp() {
        final var small = service.smallService(2, 2);
        System.out.println("small = " + small);

        final var big = service.bigService(2, 2, 2);
        System.out.println("big = " + big);
    }
}
