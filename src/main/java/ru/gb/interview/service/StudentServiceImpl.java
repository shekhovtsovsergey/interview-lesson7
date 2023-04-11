package ru.gb.interview.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.interview.converter.StudentConverter;
import ru.gb.interview.dao.StudentDao;
import ru.gb.interview.dto.StudentDto;
import ru.gb.interview.exception.StudentNotFoundException;
import ru.gb.interview.model.Student;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {


    private final StudentDao studentDao;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentDto> getAllStudent() {
        return studentDao.findAll().stream().map(studentConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<StudentDto> deleteStudentById(Long id) {
        studentDao.deleteById(id);
        return studentDao.findAll().stream().map(studentConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StudentDto createStudent(StudentDto studentDto)  {
        Student student = new Student(null, studentDto.getName(),studentDto.getAge() );
        return studentConverter.entityToDto(studentDao.save(student));
    }

    @Override
    @Transactional
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(), studentDto.getName(), studentDto.getAge());
        return studentConverter.entityToDto(studentDao.save(student));
    }


    @Override
    public StudentDto getStudentById(Long id) throws StudentNotFoundException {
        return studentConverter.entityToDto(studentDao.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }
}
