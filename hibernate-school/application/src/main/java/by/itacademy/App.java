package by.itacademy;


import by.itacademy.dao.Dao;
import by.itacademy.dao.GenericDao;
import by.itacademy.dao.impl.StudentGroupDao;
import by.itacademy.dao.provider.DaoProvider;
import by.itacademy.dao.provider.impl.DaoProviderImpl;
import by.itacademy.sessionfactory.SessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory()){
            final DaoProvider daoProvider = new DaoProviderImpl(sessionFactory);

            //создание адреса
            final Dao<Address> addressDao = daoProvider.provide(Address.class);
            final Address address = new Address();
            address.setBuildingNumber("50");
            address.setStreet("Naganova");
            address.setCity("Brest");

            addressDao.create(address);
            System.out.println(addressDao.read(address.getId()));

            //создание школы
            final Dao<School> schoolDao = daoProvider.provide(School.class);
            final School school = new School();
            school.setName("Middle school #9");
            school.setAddress(addressDao.read(address.getId()));

            schoolDao.create(school);
            System.out.println(schoolDao.read(school.getId()).toString());

            //создание предмета
            final Dao<Subject> subjectDao = daoProvider.provide(Subject.class);
            final Subject subject = new Subject();
            subject.setName("Math");

            subjectDao.create(subject);
            System.out.println(schoolDao.read(subject.getId()).toString());

            //связывание предмета и школы
            final School schoolSubject = schoolDao.read(school.getId());
            schoolSubject.setSubjects(List.of(subjectDao.read(subject.getId())));
            schoolDao.update(schoolSubject);
            final Subject subjectSchool = subjectDao.read(subject.getId());
            subjectSchool.setSchools(List.of(schoolDao.read(school.getId())));
            subjectDao.update(subjectSchool);

            //создание родителей
            final Dao<Parent> parentDao = daoProvider.provide(Parent.class);
            final Parent parent1 = new Parent();
            parent1.setFirstName("Kiryl");
            parent1.setLastName("Boubel");
            parentDao.create(parent1);

            final Parent parent2 = new Parent();
            parent2.setFirstName("Maryna");
            parent2.setLastName("Boubel");
            parentDao.create(parent2);

            //создание студента
            final Dao<Student> studentDao = daoProvider.provide(Student.class);
            final Student student = new Student();
            student.setFirstName("Yuri");
            student.setLastName("Boubel");
            studentDao.create(student);

            //связывание родителей и студента
            final Student studentParent = studentDao.read(student.getId());
            studentParent.setParents(List.of(parentDao.read(parent1.getId()), parentDao.read(parent2.getId())));
            studentDao.update(studentParent);

            final Parent parent1Student = parentDao.read(parent1.getId());
            parent1Student.setStudents(List.of(studentDao.read(student.getId())));
            parentDao.update(parent1Student);

            final Parent parent2Student = parentDao.read(parent2.getId());
            parent2Student.setStudents(List.of(studentDao.read(student.getId())));
            parentDao.update(parent2Student);

            //связывание студента и школы
            final Student studentSchool = studentDao.read(student.getId());
            studentSchool.setSchools(List.of(schoolDao.read(school.getId())));
            studentDao.update(studentSchool);

            final School schoolStudent = schoolDao.read(school.getId());
            schoolStudent.setStudents(List.of(studentDao.read(student.getId())));
            schoolDao.update(schoolStudent);

            //создание учителя
            final Dao<Teacher> teacherDao = daoProvider.provide(Teacher.class);
            final Teacher teacher = new Teacher();
            teacher.setFirstName("Anatoli");
            teacher.setLastName("Karpovich");
            teacherDao.create(teacher);

            //связывание учителя и школы
            final School schoolTeacher = schoolDao.read(school.getId());
            schoolTeacher.setTeachers(List.of(teacherDao.read(teacher.getId())));
            schoolDao.update(schoolTeacher);

            final Teacher teacherSchool = teacherDao.read(teacher.getId());
            teacherSchool.setSchools(List.of(schoolDao.read(school.getId())));
            teacherDao.update(teacherSchool);


            //создание класса
            final Dao<StudentGroup> studentGroupDao = daoProvider.provide(StudentGroup.class);
            final StudentGroup studentGroup = new StudentGroup();
            studentGroup.setName("JCB-2023");
            final School schoolStudentGroup = schoolDao.read(school.getId());
            studentGroup.setSchool(schoolStudentGroup);
            final Teacher teacherStudentGroup = teacherDao.read(teacher.getId());
            studentGroup.setGroupOwner(teacherStudentGroup);
            studentGroupDao.create(studentGroup);

            //связывание студента и группы
            final StudentGroup studentGroupStudent = studentGroupDao.read(studentGroup.getId());
            studentGroupStudent.setStudents(List.of(studentDao.read(student.getId())));
            studentGroupDao.update(studentGroupStudent);

            final Student studentStudentGroup = studentDao.read(student.getId());
            studentStudentGroup.setStudentGroups(List.of(studentGroupDao.read(studentGroup.getId())));
            studentDao.update(studentStudentGroup);

            //создание student_group_subject_link
            final Dao<StudentGroupSubjectLink> studentGroupSubjectLinkDao = daoProvider.provide(StudentGroupSubjectLink.class);
            final StudentGroupSubjectLink studentGroupSubjectLink = new StudentGroupSubjectLink();
            studentGroupSubjectLink.setStudentGroup(studentGroupDao.read(studentGroup.getId()));
            studentGroupSubjectLink.setTeacher(teacherDao.read(teacher.getId()));
            studentGroupSubjectLink.setSubject(subjectDao.read(subject.getId()));
            studentGroupSubjectLinkDao.create(studentGroupSubjectLink);

            final StudentGroup studentGroupWithLink = studentGroupDao.read(studentGroup.getId());
            studentGroupWithLink.setStudentGroupSubjectLinks(List.of(studentGroupSubjectLinkDao.read(studentGroupSubjectLink.getId())));
            studentGroupDao.update(studentGroupWithLink);

            final Subject subjectWithLink = subjectDao.read(subject.getId());
            subjectWithLink.setStudentGroupSubjectLinks(List.of(studentGroupSubjectLinkDao.read(studentGroupSubjectLink.getId())));
            subjectDao.update(subjectWithLink);

            //создание расписания
            final Dao<Schedule> scheduleDao = daoProvider.provide(Schedule.class);
            final Schedule schedule = new Schedule();
            schedule.setStartDate(OffsetDateTime.of(2023, 9, 1, 8, 0, 0, 0, ZoneOffset.ofHours(3)));
            schedule.setEndDate(OffsetDateTime.of(2024, 5, 25, 19, 0, 0, 0, ZoneOffset.ofHours(3)));
            schedule.setSchool(schoolDao.read(school.getId()));
            scheduleDao.create(schedule);

            //создание кабинета
            final Dao<GroupRoom> groupRoomDao = daoProvider.provide(GroupRoom.class);
            final GroupRoom groupRoom = new GroupRoom();
            groupRoom.setName("405");
            groupRoom.setRoomOwner(teacherDao.read(teacher.getId()));
            groupRoom.setSchool(schoolDao.read(school.getId()));
            groupRoom.setStudentGroup(studentGroupDao.read(studentGroup.getId()));
            groupRoomDao.create(groupRoom);

            //создание урока
            final Dao<Lesson> lessonDao = daoProvider.provide(Lesson.class);
            final Lesson lesson = new Lesson();
            lesson.setTeacher(teacherDao.read(teacher.getId()));
            lesson.setStudentGroup(studentGroupDao.read(studentGroup.getId()));
            lesson.setSubject(subjectDao.read(subject.getId()));
            lesson.setGroupRoom(groupRoomDao.read(groupRoom.getId()));
            lesson.setSchedule(scheduleDao.read(schedule.getId()));
            lessonDao.create(lesson);

            //создание оценки
            final Dao<Assessment> assessmentDao = daoProvider.provide(Assessment.class);
            final Assessment assessment = new Assessment();
            assessment.setAssessment(7);
            assessment.setLesson(lessonDao.read(lesson.getId()));
            assessment.setStudent(studentDao.read(student.getId()));
            assessmentDao.create(assessment);

            //создания отметки о посещении
            final Dao<Attend> attendDao = daoProvider.provide(Attend.class);
            final Attend attend = new Attend();
            attend.setVisited(true);
            attend.setLesson(lessonDao.read(lesson.getId()));
            attend.setStudent(studentDao.read(student.getId()));
            attendDao.create(attend);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
