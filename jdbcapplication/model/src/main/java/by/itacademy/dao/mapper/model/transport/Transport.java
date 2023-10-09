package by.itacademy.dao.mapper.model.transport;

import by.itacademy.dao.mapper.model.BaseModel;
import by.itacademy.dao.mapper.model.client.Client;
import by.itacademy.dao.mapper.model.modelType.ModelType;

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

    public TransportType getTransportType() {
        return transportType;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "| Id = " + getId() + " | "
                + "| Transport Type Id = " + transportType.getId() + " | "
                + "| Model type Id  = " + modelType.getId()
                + "| Client Id  = " + client.getId();
    }
}
