package by.itacademy.client;

import by.itacademy.BaseModel;

import java.util.Objects;

public class Client extends BaseModel {
    private final String firstName;

    private final String lastName;

    public Client(final Integer id, final String firstName, final String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Client id = " + getId() + " first name = " + firstName + " last name = " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Client client = (Client) o;
        return getId() == client.getId()
                && Objects.equals(firstName, client.getFirstName())
                && Objects.equals(lastName, client.getLastName());
    }
}
