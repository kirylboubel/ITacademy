package by.itacademy.dao;

public class DaoException extends Exception {
    public DaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public static class AssessmentDaoException extends DaoException {
        public AssessmentDaoException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }

    public static class StudentDaoException extends DaoException {
        public StudentDaoException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }

    public static class SubjectDaoException extends DaoException {
        public SubjectDaoException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }

    public static class TeacherDaoException extends DaoException {
        public TeacherDaoException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
