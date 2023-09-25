package by.itacademy.transport.transport;


import by.itacademy.transport.annotation.Parameter;

import java.util.Objects;

public class Transport {
    private final TransportTypeAndCost transportTypeAndCost;
    @Parameter(pattern = "^[a-zA-Z]((\s|-)?[a-zA-Z0-9])*$")
    private final String transportName;

    public Transport(final TransportTypeAndCost transportTypeAndCost, final String transportName) {
        this.transportTypeAndCost = transportTypeAndCost;
        this.transportName = transportName;
    }

    public String getTransportType() {
        return transportTypeAndCost.getDescription();
    }

    public int getTransportTax() {
        return transportTypeAndCost.getTaxValue();
    }

    public String getTransportName() {
        return transportName;
    }

    @Override
    public String toString() {
        return "<" + this.transportTypeAndCost.getDescription() + ">|<"
                + this.transportName + ">|<"
                + this.transportTypeAndCost.getTaxValue() + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Transport transport = (Transport) o;
        return transportTypeAndCost == transport.transportTypeAndCost
                && Objects.equals(transportName, transport.transportName);
    }

    @Override
    public int hashCode() {
        int result = transportTypeAndCost != null ? transportTypeAndCost.hashCode() : 0;
        result = 31 * result + (transportName != null ? transportName.hashCode() : 0);
        return result;
    }
}
