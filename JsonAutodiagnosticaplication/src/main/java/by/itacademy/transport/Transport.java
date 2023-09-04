package by.itacademy.transport;

public class Transport {
    private final TransportTypeAndCost transportTypeAndCost;
    private final String transoprtName;

    public TransportTypeAndCost getTransportTypeAndCost() {
        return transportTypeAndCost;
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

    public Transport(final TransportTypeAndCost transportTypeAndCost, final String transoprtName) {
        this.transportTypeAndCost = transportTypeAndCost;
        this.transoprtName = transoprtName;
    }

    @Override
    public String toString() {
        return "<" + this.transportTypeAndCost.getDescription() + ">|<"
                + this.transoprtName + ">|<"
                + this.transportTypeAndCost.getTaxValue() + ">";
    }
}
