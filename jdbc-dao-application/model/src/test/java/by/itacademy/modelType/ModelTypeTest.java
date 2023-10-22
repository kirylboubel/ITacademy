package by.itacademy.modelType;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTypeTest {
    final ModelType actualModelType = new ModelType(10, "BMW X-7");

    @Test
    void testGetName_happyPath() {
        //given
        final String expectedModelType = "BMW X-7";

        //when
        final String actualModelType = this.actualModelType.getName();

        //then
        assertEquals(expectedModelType, actualModelType);
    }

    @Test
    void testGetId_happyPath() {
        //given
        final int expectedId = 10;

        //when
        final int actualId = actualModelType.getId();

        //
        assertEquals(expectedId, actualId);
    }

    @Test
    void testToString_happyPath() {
        //given
        final String expectedToString = "Model Type id = 10 transport model = BMW X-7";

        //when
        final String actualToString = actualModelType.toString();

        //then
        assertEquals(expectedToString, actualToString);
    }
}