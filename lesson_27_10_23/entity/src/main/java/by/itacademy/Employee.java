package by.itacademy;

public class Employee {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final EmployeeType employeeType;

    public Employee(
            final Integer id,
            final String firstName,
            final String lastName,
            final EmployeeType employeeType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeType = employeeType;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
