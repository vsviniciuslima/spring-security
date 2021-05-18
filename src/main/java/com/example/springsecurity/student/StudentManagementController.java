package com.example.springsecurity.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "Alejandro"),
            new Student(2, "Parente"),
            new Student(3, "Andrew")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("get student:");
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("register new student:");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentIt) {
        System.out.println("delete student:");

        System.out.println(studentIt);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("update student:");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
