package com.example.EnrollmentNew.Enroll;

import com.example.EnrollmentNew.Course.Course;
import com.example.EnrollmentNew.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollController {

    @Autowired
    EnrollServices enrollServices;

/****************************Information related to student that enrolled into the courses ************************/

    // Prerequisites that course has to be present before student can enroll in that
    @PostMapping(path = "/student/enroll/{studentId}/{courseId}")
    public void addCourseToStudent(@PathVariable Integer studentId,
                                   @PathVariable Integer courseId){
        enrollServices.addCourseToStudent(studentId,courseId);
    }

    @DeleteMapping(path = "/student/drop/{studentId}/{courseId}")
    public void dropCourseFromStudent(@PathVariable Integer studentId,
                                      @PathVariable Integer courseId){
        enrollServices.dropCourseFromStudent(studentId,courseId);
    }

    @GetMapping(path = "/student/{studentId}/courses")
    public List<Course> getAllCourseStudentEnroll(@PathVariable Integer studentId){
        return enrollServices.getAllCourseStudentEnrolled(studentId);
    }

/**************************** Information related to course that enrolled by the students ************************/

    // to see what are the students are enrolled in specific course
    @GetMapping(path = "/List/students/course/{courseId}")
    public List<Student> getStudentEnrolledCourse(@PathVariable Integer courseId){
        return enrollServices.getStudentsEnrolledCourse(courseId);
    }

    @GetMapping(path = "/enrollIn/course/{courseId}/NoOfStudents")
    public Integer getTotalStudentEnrolledInCourse(@PathVariable Integer courseId){
        return enrollServices.getTotalStudentEnrolledInCourse(courseId);
    }

    // Instructor can drop the student from the course
    @DeleteMapping(path =  "drop/student/{studentId}/from/course/{courseId}")
    public void dropStudentFromCourse(@PathVariable Integer courseId,
                                      @PathVariable Integer studentId){
        enrollServices.dropStudentFromCourse(courseId,studentId);
    }

}
