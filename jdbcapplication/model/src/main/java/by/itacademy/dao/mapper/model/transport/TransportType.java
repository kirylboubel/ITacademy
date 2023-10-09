package by.itacademy.dao.model.transport;

import by.itacademy.dao.model.IdField;
import by.itacademy.dao.model.NameField;

public enum TransportType implements IdField, NameField {
    MOTORBIKE(1, "motorbike"),
    AUTOMOBILE(2, "automobile"),
    MINIBUS(3, "minibus");
    private final Integer id;
    private final String name;

    TransportType(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
