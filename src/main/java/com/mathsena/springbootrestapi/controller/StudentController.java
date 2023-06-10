package com.mathsena.springbootrestapi.controller;

import com.mathsena.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/students


    @GetMapping("/students")
    public Student getStudent(){
        Student student = new Student(1, "Matheus", "Sena");
        return student;
    }



}
