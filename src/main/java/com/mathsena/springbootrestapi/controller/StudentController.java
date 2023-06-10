package com.mathsena.springbootrestapi.controller;

import com.mathsena.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring BOOT REST API ith Path variable
    //{id} -> URI Template variable
    // http://localhost:8080/students/100

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Diego&lastName=Maradona

    @GetMapping("students/query")
     public Student studentRequestVariable(@RequestParam int id,
                                           @RequestParam  String firstName,
                                           @RequestParam  String lastName){
        return new Student(id, firstName, lastName);

    }


    // Spring boot REST API that handles HTTP POST
    // @PostMapping and @RequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot REST API That handles HTTP PUT Request - update an ID

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }

    //Spring Boot REST API that handles HTTP Delete Request - Deleting an id
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        return studentId + " deleted successfully";

    }









}
