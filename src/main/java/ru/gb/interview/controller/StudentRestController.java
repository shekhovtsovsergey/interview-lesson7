package ru.gb.interview.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.interview.dto.StudentDto;
import ru.gb.interview.exception.StudentNotFoundException;
import ru.gb.interview.service.StudentService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentRestController {
    private final StudentService studentService;
    @GetMapping("/api/v1/student")
    public List<StudentDto> getStudentList() {
        return studentService.getAllStudent();
    }
    @GetMapping("/api/v1/student/{id}")
    public StudentDto getStudentById(@PathVariable(name = "id") Long id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/api/v1/student/{id}")
    public void deleteStudentById(@PathVariable(name = "id") Long id) {
        studentService.deleteStudentById(id);
    }
    @PutMapping("/api/v1/student/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }
    @PostMapping("/api/v1/student")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }
    @ExceptionHandler({StudentNotFoundException.class})
    private ResponseEntity<String> handleNotFound(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
