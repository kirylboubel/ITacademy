package by.itacademy.transport;

import by.itacademy.annotation.Parametr;

public class Transport {
    @Parametr(name = "TransportTypeAndCost")
    private final TransportTypeAndCost transportTypeAndCost;
    @Parametr (name = "transoprtName")
    private final String transoprtName;

    public Transport(final TransportTypeAndCost transportTypeAndCost, final String transoprtName) {
        this.transportTypeAndCost = transportTypeAndCost;
        this.transoprtName = transoprtName;
    }

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

    @Override
    public String toString() {
        return "<" + this.transportTypeAndCost.getDescription() + ">|<"
                + this.transoprtName + ">|<"
                + this.transportTypeAndCost.getTaxValue() + ">";
    }
}
