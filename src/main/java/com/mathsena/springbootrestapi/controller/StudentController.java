package com.mathsena.springbootrestapi.controller;

import com.mathsena.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/students


    @GetMapping("/students")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Matheus", "Sena");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Matheus").body(student);
    }


    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> getAllStudents(){
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

        return ResponseEntity.ok(students);

    }

    // Spring BOOT REST API ith Path variable
    //{id} -> URI Template variable
    // http://localhost:8080/students/100

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Diego&lastName=Maradona

    @GetMapping("students/query")
     public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                           @RequestParam  String firstName,
                                           @RequestParam  String lastName){
        Student student =  new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);

    }


    // Spring boot REST API that handles HTTP POST
    // @PostMapping and @RequestBody

    @PostMapping("students/create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring Boot REST API That handles HTTP PUT Request - update an ID

    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);

    }

    //Spring Boot REST API that handles HTTP Delete Request - Deleting an id
    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        return ResponseEntity.ok(studentId + " deleted successfully");

    }









}
