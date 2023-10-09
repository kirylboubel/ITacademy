package by.itacademy.dao.model.transport;

import by.itacademy.dao.model.BaseModel;
import by.itacademy.dao.model.client.Client;
import by.itacademy.dao.model.modelType.ModelType;

public class Transport extends BaseModel {
    private final TransportType transportType;
    private final ModelType modelType;
    private final Client client;

    public Transport(final Integer id, final TransportType transportType, final ModelType modelType, final Client client) {
        super(id);
        this.transportType = transportType;
        this.modelType = modelType;
        this.client = client;
    }

    @Override
    public String toString() {
        return "| Transport name = " + modelType.getName() + " | "
                + "| Transport type = " + transportType.toString() + " | "
                + "| Client first name = " + client.getFirstName() + " | "
                + "| Client last name = " + client.getLastName() + " | ";
    }
}
