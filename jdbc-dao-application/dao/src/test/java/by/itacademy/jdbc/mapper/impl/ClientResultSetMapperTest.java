package by.itacademy.jdbc.mapper.impl;

import by.itacademy.client.Client;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientResultSetMapperTest {
    @Mock
    private ResultSet resultSet;

    @Test
    void testMap_happyPath() throws SQLException, ResultSetMapperException {
        //given
        final Client expectedClient = new Client(10, "John", "Conor");
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(expectedClient.getId());
        when(resultSet.getString("first_name")).thenReturn(expectedClient.getFirstName());
        when(resultSet.getString("last_name")).thenReturn(expectedClient.getLastName());

        //when
        final Client actualClient = new ClientResultSetMapper().map(resultSet);

        //then
        assertNotNull(actualClient, "actualClient is null");
        assertEquals(expectedClient.getId(), actualClient.getId());
        assertEquals(expectedClient.getFirstName(), actualClient.getFirstName());
        assertEquals(expectedClient.getLastName(), actualClient.getLastName());

        verify(resultSet).next();
        verify(resultSet).getInt("id");
        verify(resultSet).getString("first_name");
        verify(resultSet).getString("last_name");
        verifyNoMoreInteractions(resultSet);
    }

    @Test
    void testMap_ResultSetMapperException() throws SQLException {
        //given
        final Client expectedClient = new Client(10, "John", "Conor");
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(expectedClient.getId());
        when(resultSet.getString("first_name")).thenThrow(SQLException.class);

        //then
        assertThrows(ResultSetMapperException.class, () -> {
            final Client actualClient = new ClientResultSetMapper().map(resultSet);
        });
    }
}