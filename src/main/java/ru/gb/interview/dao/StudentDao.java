package ru.gb.interview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.interview.model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}