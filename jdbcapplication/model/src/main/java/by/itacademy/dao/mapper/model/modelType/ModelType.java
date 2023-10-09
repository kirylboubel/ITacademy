package by.itacademy.dao.mapper.model.modelType;

import by.itacademy.dao.mapper.model.BaseModel;
import by.itacademy.dao.mapper.model.NameField;

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
}
