package com.example.springsecurity.student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student {

    private final Integer studentId;
    private final String studentName;
}
