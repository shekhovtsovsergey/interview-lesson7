package ru.gb.interview.service;


import ru.gb.interview.dto.StudentDto;
import ru.gb.interview.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudent();
    List<StudentDto> deleteStudentById(Long id);
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id) throws StudentNotFoundException;

}
