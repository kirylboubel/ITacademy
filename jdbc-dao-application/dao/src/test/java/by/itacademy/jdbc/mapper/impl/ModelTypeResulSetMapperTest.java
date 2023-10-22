package by.itacademy.jdbc.mapper.impl;

import by.itacademy.jdbc.mapper.ResultSetMapperException;
import by.itacademy.modelType.ModelType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModelTypeResulSetMapperTest {
@Mock
private ResultSet resultSet;
    @Test
    void testMap_happyPath() throws SQLException, ResultSetMapperException {
        //given
        final ModelType expectedModelType = new ModelType(10, "BMW X-7");
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(expectedModelType.getId());
        when(resultSet.getString("name")).thenReturn(expectedModelType.getName());

        //when
        final ModelType actualModelType = new ModelTypeResulSetMapper().map(resultSet);

        //then
        assertNotNull(actualModelType, "actualModelType is null");
        assertEquals(expectedModelType.getId(), actualModelType.getId());
        assertEquals(expectedModelType.getName(), actualModelType.getName());

        verify(resultSet).next();
        verify(resultSet).getInt("id");
        verify(resultSet).getString("name");
        verifyNoMoreInteractions(resultSet);
    }

    @Test
    void testMap_ResultSetMapperException() throws SQLException {
        //given
        final ModelType expectedModelType = new ModelType(10, "BMW X-7");
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(expectedModelType.getId());
        when(resultSet.getString("name")).thenThrow(SQLException.class);

        //then
        assertThrows(ResultSetMapperException.class, () -> {
            final ModelType actualModelType = new ModelTypeResulSetMapper().map(resultSet);
        });
    }
}