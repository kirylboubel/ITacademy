package by.itacademy.service;

import by.itacademy.aspect.annotation.ExecutionTime;
import by.itacademy.controller.dto.StudentDto;

public interface StudentService {
    Integer create(StudentDto studentDto);
    StudentDto read(Integer id);

}
