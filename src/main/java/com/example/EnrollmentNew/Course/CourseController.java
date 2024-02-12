package com.example.EnrollmentNew.Course;


import com.example.EnrollmentNew.Student.Student;
import com.example.EnrollmentNew.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseServices courseServices;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;



    /************************************************* To access All the Course Information *********************/

    @GetMapping(path = "/course/getAll")
    public List<Course> getAllCourse(){
        return courseServices.getAllCourse();
    }

    @GetMapping(path = "/course/{courseId}")
    public Course getCourse(@PathVariable Integer courseId){
        return courseServices.getCourse(courseId);
    }

    // to add the course
    @PostMapping(path = "/course")
    public void addCourse(@RequestBody Course course){
        courseServices.addCourse(course);
    }

    @PutMapping(path = "/course/{courseId}")
    public void updateCourse(@RequestBody Course course,@PathVariable Integer courseId){
        courseServices.updateCourse(course,courseId);
    }

    @DeleteMapping(path = "/course/{courseId}")
    public  void deleteCourse(@PathVariable Integer courseId){
        courseServices.deleteCourse(courseId);
    }




}
