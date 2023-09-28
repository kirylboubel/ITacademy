package by.itacademy.transport;

import by.itacademy.client.Client;
import by.itacademy.transportName.TransportName;

public class Transport {
    private final TransportType transportType;
    private final TransportName transportName;
    private final Client client;

    public Transport(TransportType transportType, TransportName transportName, Client client) {
        this.transportType = transportType;
        this.transportName = transportName;
        this.client = client;
    }

    @Override
    public String toString() {
        return "| Transport name = " + transportName.getTransportModel() + " | "
                + "| Transport type = " + transportType.toString() + " | "
                + "| Client first name = " + client.getFirstName() + " | "
                + "| Client last name = " + client.getLastName() + " | ";
    }
}
