package by.itacademy.service.impl;

import by.itacademy.aspect.annotation.ExecutionTime;
import by.itacademy.controller.dto.StudentDto;
import by.itacademy.entity.Student;
import by.itacademy.service.StudentService;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @ExecutionTime
    @Override
    public Integer create(StudentDto studentDto) {
        final Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        sessionFactory.getCurrentSession().persist(student);
        return student.getId();
    }

    @Transactional
    @ExecutionTime
    @Override
    public StudentDto read(Integer id) {
        final Student student = sessionFactory.getCurrentSession().find(Student.class, id);
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName());
    }
}
