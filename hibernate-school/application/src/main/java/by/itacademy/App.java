package by.itacademy;


import by.itacademy.dao.Dao;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.impl.AssessmentDao;
import by.itacademy.dao.impl.StudentDao;
import by.itacademy.dao.impl.SubjectDao;
import by.itacademy.dao.impl.TeacherDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) throws DaoException {
        ApplicationContext context = new AnnotationConfigApplicationContext("by.itacademy.config");

        //student creation
        final Dao<Student> studentDao = context.getBean(StudentDao.class);
        final Student student = new Student();
        student.setId(1);
        student.setFirstName("Kiryl");
        student.setLastName("Boubel");

        studentDao.create(student);
        System.out.println(studentDao.read(1));

        //teacher creation
        final Dao<Teacher> teacherDao = context.getBean(TeacherDao.class);
        final Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setFirstName("Anatoli");
        teacher.setLastName("Chubais");

        teacherDao.create(teacher);
        System.out.println(teacherDao.read(1));

        //subject creation
        final Dao<Subject> subjectDao = context.getBean(SubjectDao.class);
        final Subject subject = new Subject();
        subject.setId(1);
        subject.setName("math");

        subjectDao.create(subject);
        System.out.println(subjectDao.read(subject.getId()));

        //subject and teacher merging
        teacher.setSubjects(List.of(subject));
        teacherDao.update(teacher);

        subject.setTeachers(List.of(teacher));
        subjectDao.update(subject);

        //assessment creation
        final Dao<Assessment> assessmentDao = context.getBean(AssessmentDao.class);
        final Assessment assessment = new Assessment();
        assessment.setId(1);
        assessment.setAssessment(7);
        assessment.setSubject(subject);
        assessment.setStudent(student);

        assessmentDao.create(assessment);
        System.out.println(assessmentDao.read(1));
    }
}
