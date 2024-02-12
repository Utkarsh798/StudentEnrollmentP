package com.example.EnrollmentNew.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServices studentServices;


    @GetMapping(path = "/student/getAll")
    public List<Student> getAllStudents(){
        return studentServices.getAllStudent();
    }


    @GetMapping(path = "/student/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentServices.getStudent(id);
    }


    @PostMapping(path = "/student")
    public void addStudent(@RequestBody Student student){
        studentServices.addStudent(student);
    }


    @PutMapping(path = "/student/{id}")
    public void updateStudent(@RequestBody Student student , @PathVariable Integer id){
        studentServices.updateStudent(student,id);
    }


    @DeleteMapping(path = "/student/{id}")
    public void delete(@PathVariable Integer id){
        studentServices.deleteStudent(id);
    }
}
