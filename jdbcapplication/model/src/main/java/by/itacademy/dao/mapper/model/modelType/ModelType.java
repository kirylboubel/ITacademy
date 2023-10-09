package by.itacademy.dao.model.modelType;

import by.itacademy.dao.model.BaseModel;
import by.itacademy.dao.model.NameField;

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
}
