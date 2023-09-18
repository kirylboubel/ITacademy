package by.itacademy.transport;


import java.util.Objects;

public class Transport {
    private final TransportTypeAndCost transportTypeAndCost;
    private final String transoprtName;

    public Transport(final TransportTypeAndCost transportTypeAndCost, final String transoprtName) {
        this.transportTypeAndCost = transportTypeAndCost;
        this.transoprtName = transoprtName;
    }

    public String getTransportType() {
        return transportTypeAndCost.getDescription();
    }

    public int getTransportTax() {
        return transportTypeAndCost.getTaxValue();
    }

    public String getTransoprtName() {
        return transoprtName;
    }

    @Override
    public String toString() {
        return "<" + this.transportTypeAndCost.getDescription() + ">|<"
                + this.transoprtName + ">|<"
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
                && Objects.equals(transoprtName, transport.transoprtName);
    }

    @Override
    public int hashCode() {
        int result = transportTypeAndCost != null ? transportTypeAndCost.hashCode() : 0;
        result = 31 * result + (transoprtName != null ? transoprtName.hashCode() : 0);
        return result;
    }
}
