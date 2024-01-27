package by.itacademy.service;

import by.itacademy.controller.dto.StudentDto;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface StudentService {

    Integer create(StudentDto studentDto);

    StudentDto read (Integer id);

}
