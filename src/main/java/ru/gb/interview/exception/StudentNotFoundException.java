package ru.gb.interview.exception;

import javassist.tools.rmi.ObjectNotFoundException;

public class StudentNotFoundException extends ObjectNotFoundException {

    public StudentNotFoundException(Long studentId) {
        super(String.format("Student id %s not found", studentId));
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
