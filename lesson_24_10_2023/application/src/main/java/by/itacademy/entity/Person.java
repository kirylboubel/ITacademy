package by.itacademy.entity;

import java.util.Objects;

public class Person {
    private final Integer id;
    private final String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id = " + id + " name = " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Person person = (Person) obj;
        return getId() == person.getId()
                && Objects.equals(name, person.getName());
    }
}
