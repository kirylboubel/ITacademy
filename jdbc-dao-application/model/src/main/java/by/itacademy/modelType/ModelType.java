package by.itacademy.modelType;

import by.itacademy.BaseModel;
import by.itacademy.NameField;
import by.itacademy.client.Client;

import java.util.Objects;

public class ModelType extends BaseModel implements NameField {
    private final String transportModel;

    public ModelType(final Integer id, final String transportModel) {
        super(id);
        this.transportModel = transportModel;
    }

    @Override
    public String getName() {
        return transportModel;
    }

    @Override
    public String toString() {
        return "Model Type id = " + getId() + " transport model = " + transportModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ModelType modelType = (ModelType) o;
        return getId() == modelType.getId()
                && Objects.equals(transportModel, modelType.getName());
    }
}
