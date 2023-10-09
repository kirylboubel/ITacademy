package by.itacademy.dao.jdbc.mapper.model;

import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.IdField;
import by.itacademy.dao.mapper.model.client.Client;
import by.itacademy.dao.mapper.model.modelType.ModelType;
import by.itacademy.dao.mapper.model.transport.Transport;
import by.itacademy.dao.mapper.model.transport.TransportType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportResulSetMapper implements ResultSetMapper<Transport> {

    @Override
    public Transport map(final ResultSet resultSet) throws ResultSetMapperException {
        try {
            if (!resultSet.next()) {
                return null;
            }
            final Integer id = resultSet.getInt("id");

            final Integer modelTypeID = resultSet.getInt("model_type_id");
            final ModelType modelType = new ModelType(modelTypeID, null);

            final Integer transportTypeID = resultSet.getInt("transport_type_id");
            final TransportType transportType = mapToEnum(TransportType.class, transportTypeID);

            final Integer clientId = resultSet.getInt("client_id");
            final Client client = new Client(clientId, null, null);

            return new Transport(id, transportType, modelType, client);
        } catch (final SQLException e) {
            throw new ResultSetMapperException("Failed to pare", e);
        }
    }

    private static <T extends Enum<T> & IdField> T mapToEnum(final Class<T> enumClass, final Integer id) {
        for (final T value : enumClass.getEnumConstants()) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }
}
