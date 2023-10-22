package by.itacademy.jdbc.mapper.impl;

import by.itacademy.client.Client;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import by.itacademy.modelType.ModelType;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransportResulSetMapperTest {
    @Mock
    private ResultSet resultSet;

    @Test
    void testMap_happyPath() throws SQLException, ResultSetMapperException {
        //given
        final Client expectedClient = new Client(10, "John", "Conor");
        final ModelType expectedModelType = new ModelType(10, "BMW X-7");
        final TransportType expectedTransportType = TransportType.AUTOMOBILE;
        final Transport expectedTransport = new Transport(10, expectedTransportType, expectedModelType, expectedClient);

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(expectedTransport.getId());
        when(resultSet.getInt("model_type_id")).thenReturn(expectedTransport.getModelType().getId());
        when(resultSet.getInt("transport_type_id")).thenReturn(expectedTransport.getTransportType().getId());
        when(resultSet.getInt("client_id")).thenReturn(expectedTransport.getClient().getId());

        //when
        final Transport actualTransport = new TransportResulSetMapper().map(resultSet);

        //then
        assertNotNull(actualTransport, "actualTransport is null");
        assertEquals(expectedTransport.getId(), actualTransport.getId());
        assertEquals(expectedTransportType.getId(), actualTransport.getTransportType().getId());
        assertEquals(expectedModelType.getId(), actualTransport.getModelType().getId());
        assertEquals(expectedClient.getId(), actualTransport.getClient().getId());

        verify(resultSet).next();
        verify(resultSet).getInt("id");
        verify(resultSet).getInt("model_type_id");
        verify(resultSet).getInt("transport_type_id");
        verify(resultSet).getInt("client_id");
        verifyNoMoreInteractions(resultSet);
    }

    @Test
    void testMap_ResultSetMapperException() throws SQLException {
        //given
        final Transport expectedTransport = new Transport(10, null, null, null);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenThrow(SQLException.class);

        //then
        assertThrows(ResultSetMapperException.class, () -> {
            final Transport actualTransport = new TransportResulSetMapper().map(resultSet);
        });
    }
}