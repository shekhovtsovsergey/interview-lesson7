package ru.gb.interview.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.interview.dto.StudentDto;
import ru.gb.interview.model.Student;

@Component
@RequiredArgsConstructor
public class StudentConverter {

    public StudentDto entityToDto(Student student) {
        return new StudentDto(student.getId(), student.getName(),student.getAge());
    }

}
