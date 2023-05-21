package com.example.restback.service;

import com.example.restback.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student add(Student student);
    Student update(UUID id, Student student);
    void delete(UUID id);
    List<Student> get();
}
