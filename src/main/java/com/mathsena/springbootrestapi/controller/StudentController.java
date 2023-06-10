package com.mathsena.springbootrestapi.controller;

import com.mathsena.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/students


    @GetMapping("/students")
    public Student getStudent(){
        Student student = new Student(1, "Matheus", "Sena");
        return student;
    }

    @GetMapping("/all-students")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Cássio", "Ramos"));
        students.add(new Student(2, "Fagner", "Silva"));
        students.add(new Student(6, "Fábio", "Santos"));
        students.add(new Student(3, "Gil", "Silva"));
        students.add(new Student(4, "Murillo", "Alves"));
        students.add(new Student(5, "Roni", "Ribeiro"));
        students.add(new Student(8, "Fausto", "Vera"));
        students.add(new Student(7, "Renato", "Augusto"));
        students.add(new Student(10, "Roger", "Guedes"));
        students.add(new Student(12, "Vanderlei", "Luxemburgo"));

        return students;

    }



}
