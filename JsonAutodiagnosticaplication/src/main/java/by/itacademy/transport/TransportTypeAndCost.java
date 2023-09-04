package by.itacademy.transport;

public enum TransportTypeAndCost {

    MOTORBIKE("мотоцикл", 10),
    AUTOMOBILE("автомобиль", 20),
    MINIBUS("микроавтобус", 30);
    private String description;
    private int taxValue;

    TransportTypeAndCost(final String description, final int taxValue) {
        this.description = description;
        this.taxValue = taxValue;
    }

    public String getDescription() {
        return description;
    }

    public int getTaxValue() {
        return taxValue;
    }
}
