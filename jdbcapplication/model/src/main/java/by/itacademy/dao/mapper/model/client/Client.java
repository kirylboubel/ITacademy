package by.itacademy.dao.mapper.model.client;

import by.itacademy.dao.mapper.model.BaseModel;

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
}
