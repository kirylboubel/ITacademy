package by.itacademy.dao.mapper.model.transport;

import by.itacademy.dao.mapper.model.IdField;
import by.itacademy.dao.mapper.model.NameField;

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

    public TransportType getEnumByIndex(Integer index) {
        for (TransportType t : TransportType.values()) {
            if (t.getId() == index) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Transport type id = " + getId() + " Transport name = " + getName();
    }
}
