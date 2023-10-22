package by.itacademy.dao.jdbc.impl;

import by.itacademy.Dao;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.datasource.factory.DataSourcePropertiesFactory;
import by.itacademy.datasource.factory.impl.FileDataSourcePropertiesFactory;
import by.itacademy.jdbc.impl.ModelTypeJdbcDao;
import by.itacademy.jdbc.mapper.impl.ModelTypeResulSetMapper;
import by.itacademy.modelType.ModelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTypeJdbcDaoIntegrationTest extends BaseJdbcDaoIntegrationTest {

    @Test
    void testCreateModelType_happyPath() throws Exception {
        //given
        final DataSourcePropertiesFactory factory = new FileDataSourcePropertiesFactory();
        final JdbcDataSourceProperties properties = factory.create("application-test.properties");
        final ModelTypeResulSetMapper mapper = new ModelTypeResulSetMapper();

        final Dao<ModelType> modelTypeDao = new ModelTypeJdbcDao(properties, mapper);
        final ModelType modelType = new ModelType(null, "BMW X-&");

        //when
        final Integer id = modelTypeDao.create(modelType);

        //then
        final ResultSetVerifier verifier = (rs) -> {
            final Integer modelTypeId = rs.getInt("id");
            final String modelTypeName = rs.getString("name");

            Assertions.assertEquals(id, modelTypeId);
            Assertions.assertEquals(modelType.getName(), modelTypeName);
        };

        verifyCreatedRow("model_type", id, verifier);
    }
}
