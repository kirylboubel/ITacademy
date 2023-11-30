package by.itacademy;


import by.itacademy.dao.GenericDao;
import by.itacademy.dao.provider.DaoProvider;
import by.itacademy.dao.provider.impl.DaoProviderImpl;
import by.itacademy.sessionfactory.SessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory()){
            final DaoProvider daoProvider = new DaoProviderImpl(sessionFactory);

            //создание адреса
            final GenericDao<Address> addressDao = daoProvider.provide(Address.class);
            final Address address = new Address();
            address.setBuildingNumber("50");
            address.setStreet("Naganova");
            address.setCity("Brest");

            addressDao.create(address);
            System.out.println(addressDao.read(address.getId()));

            //создание школы
            final GenericDao<School> schoolDao = daoProvider.provide(School.class);
            final School school = new School();
            school.setName("Middle school #9");
            school.setAddress(addressDao.read(address.getId()));

            schoolDao.create(school);
            System.out.println(schoolDao.read(school.getId()).toString());

            //создание предмета
            final GenericDao<Subject> subjectDao = daoProvider.provide(Subject.class);
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
            final GenericDao<Parent> parentDao = daoProvider.provide(Parent.class);
            final Parent parent1 = new Parent();
            parent1.setFirstName("Kiryl");
            parent1.setLastName("Boubel");
            parentDao.create(parent1);

            final Parent parent2 = new Parent();
            parent2.setFirstName("Maryna");
            parent2.setLastName("Boubel");
            parentDao.create(parent2);

            //создание студента
            final GenericDao<Student> studentDao = daoProvider.provide(Student.class);
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


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
