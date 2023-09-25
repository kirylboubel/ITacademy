package by.itacademy.transport.transport;

public enum TransportTypeAndCost {

    MOTORBIKE("motorbike", 10),
    AUTOMOBILE("automobile", 20),
    MINIBUS("minibus", 30);
    final private String description;
    final private int taxValue;

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
