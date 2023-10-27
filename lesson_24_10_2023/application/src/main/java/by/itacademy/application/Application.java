package by.itacademy.application;

import by.itacademy.dao.Dao;
import by.itacademy.dao.provider.DaoProvider;
import by.itacademy.datasource.factory.impl.FileDataSourcePropertiesFactory;
import by.itacademy.entity.Person;
import by.itacademy.jdbc.provider.JdbcDaoProvider;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final var dataSourcePropertiesFactory = new FileDataSourcePropertiesFactory();
            final var properties = dataSourcePropertiesFactory.create("application.properties");

            final DaoProvider provider = new JdbcDaoProvider(properties);

            final Dao<Person> personDao = provider.provide(Person.class);

            System.out.println("Введите значение name для Person");
            final String personName = scanner.nextLine();

            final Person person = new Person(null, personName);

            final Integer personId = personDao.create(person);

            final Person personCreated = personDao.read(personId);
            System.out.println(personCreated);
        } catch (final Exception e) {
            System.err.println("Program error " + e);
            e.printStackTrace();
        }
    }
}
