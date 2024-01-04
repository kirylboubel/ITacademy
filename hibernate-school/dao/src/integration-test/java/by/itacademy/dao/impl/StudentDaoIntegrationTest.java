package by.itacademy.dao.impl;

import by.itacademy.Student;
import by.itacademy.dao.DaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static by.itacademy.dao.impl.SessionFactoryTest.SESSION_FACTORY;

public class StudentDaoIntegrationTest extends BaseHibernateIntegrationTest {
    private static final StudentDao STUDENT_DAO = new StudentDao(SESSION_FACTORY);

    @Test
    void testCreateStudent_happyPath() throws DaoException {
        final Student student = new Student();
        student.setId(1);
        student.setFirstName("Kiryl");
        student.setLastName("Boubel");

        STUDENT_DAO.create(student);

        final ResultSetVerifier verifier = resultSet -> {
            final Integer studentId = resultSet.getInt("id");
            final String firstName = resultSet.getString("first_name");
            final String lastName = resultSet.getString("last_name");

            Assertions.assertEquals(student.getId(), studentId);
            Assertions.assertEquals(student.getFirstName(), firstName);
            Assertions.assertEquals(student.getLastName(), lastName);
        };
        verifyCreatedRow("address", student.getId(), verifier);
    }

    @Test
    void testReadStudent_happyPath() throws SQLException, DaoException {
        final Statement statement = connection.createStatement();
        statement.executeUpdate("insert into student (first_name, last_name) values ('Petr', 'Varashylov')");

        final Student readStudent = STUDENT_DAO.read(1);

        Assertions.assertEquals(readStudent.getId(), 1);
        Assertions.assertEquals(readStudent.getFirstName(), "Petr");
        Assertions.assertEquals(readStudent.getLastName(), "Varashylov");
    }

    @Test
    void testUpdateStudent_happyPath() throws SQLException, DaoException {
        final Student student = new Student();
        student.setId(1);
        student.setFirstName("Kiryl");
        student.setLastName("Varashylov");

        final Statement statement = connection.createStatement();
        statement.executeUpdate("insert into student (first_name, last_name) values ('Kiryl', 'Boubel')");
        STUDENT_DAO.update(student);

        final String selectSql = "select * from student where id = 1";
        try (final PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Integer studentId = resultSet.getInt("id");
                final String studentFirstName = resultSet.getString("first_name");
                final String studentLastName = resultSet.getString("last_name");

                Assertions.assertEquals(1, studentId);
                Assertions.assertEquals("Kiryl", studentFirstName);
                Assertions.assertEquals("Varashylov", studentLastName);
            }
        }
    }
}
