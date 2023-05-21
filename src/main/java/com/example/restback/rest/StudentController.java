package com.example.restback.rest;

import com.example.restback.model.Student;
import com.example.restback.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public List<Student> getAll() {
        return this.studentService.get();
    }

    @PostMapping()
    public Student add(@RequestBody Student student) {
        return this.studentService.add(student);
    }

    @PutMapping()
    public Student update(@PathVariable("id") UUID id, Student student) {
        return this.studentService.update(id, student);
    }

    @DeleteMapping()
    public void delete(@PathVariable("id") UUID id) {
        this.studentService.delete(id);
    }
}
