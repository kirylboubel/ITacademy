package by.itacademy;

public enum EmployeeType {
    BUILDER(1, "builder"),
    TEACHER(2, "teacher");
    private final Integer id;
    private final String employeeType;

    EmployeeType(Integer id, String employeeType) {
        this.id = id;
        this.employeeType = employeeType;
    }

    public Integer getId() {
        return id;
    }

    public String getEmployeeType() {
        return employeeType;
    }
}
