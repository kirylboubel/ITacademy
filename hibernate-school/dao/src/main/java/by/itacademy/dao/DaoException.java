package by.itacademy.dao;

public class DaoException extends Exception {
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class AddressDaoException extends DaoException {
        public AddressDaoException(final String message, final Exception cause) {
            super(message, cause);
        }
    }

    public static class AssessmentDaoException extends DaoException {
        public AssessmentDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class AttendDaoException extends DaoException {
        public AttendDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class GroupRoomDaoException extends DaoException {
        public GroupRoomDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class LessonDaoException extends DaoException {
        public LessonDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ParentDaoException extends DaoException {
        public ParentDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ScheduleDaoException extends DaoException {
        public ScheduleDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class SchoolDaoException extends DaoException {
        public SchoolDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class StudentDaoException extends DaoException {
        public StudentDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class StudentGroupDaoException extends DaoException {
        public StudentGroupDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class SubjectDaoException extends DaoException {
        public SubjectDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class TeacherDaoException extends DaoException {
        public TeacherDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
