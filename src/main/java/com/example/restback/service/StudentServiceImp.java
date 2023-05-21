package com.example.restback.service;

import com.example.restback.exception.AssesmentException;
import com.example.restback.model.Student;
import com.example.restback.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student update(UUID id, Student student) {
        Student toUpdate = this.studentRepository.findById(id).orElseThrow(() -> new AssesmentException("Student not found"));

        toUpdate.setFullName(student.getFullName());
        toUpdate.setEmail(student.getEmail());
        toUpdate.setPhoneNumber(student.getPhoneNumber());
        toUpdate.setAddress(student.getAddress());

        return this.studentRepository.save(toUpdate);
    }

    @Override
    public void delete(UUID id) {
        Student toDelete = this.studentRepository.findById(id).orElseThrow(() -> new AssesmentException("Course not found"));

        this.studentRepository.delete(toDelete);
    }

    @Override
    public List<Student> get() {
        return this.studentRepository.findAll();
    }
}
