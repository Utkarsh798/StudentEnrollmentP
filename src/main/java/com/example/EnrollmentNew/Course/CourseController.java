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


//
//
//    @GetMapping(path = "student/{studentId}/course")
//    public List<Course> getAllCourseBasedStudent(@PathVariable Integer studentId){
//        return courseServices.getAllCourseByStudent(studentId);
//    }
//
//    @GetMapping(path = "student/{studentId}/course/{courseId}")
//    public Optional<Course> getCourseBasedStudent(@PathVariable Integer courseId,
//                                                  @PathVariable Integer studentId){
//        return courseServices.getcoursebyStudent(studentId,courseId);
//    }
//
//
//    @PostMapping(path = "student/{studentId}/course")
//    public void addCourseToStudent(@RequestBody Course course,
//                                   @PathVariable Integer studentId){
//        Optional<Student> studentOptional = studentRepository.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//            course.setStudent(student);
//            courseServices.addCourseByStudent(course);
//        }
//    }
//
//    @PutMapping(path = "student/{studentId}/course/{courseId}")
//    public void updateCourseToStudent(@RequestBody Course course,
//                                      @PathVariable Integer studentId,
//                                      @PathVariable Integer courseId){
//        Optional<Student> studentOptional = studentRepository.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//            Optional<Course> existingCourseOptional = courseRepository.findById(courseId);
//            if (existingCourseOptional.isPresent()) {
//                Course existingCourse = existingCourseOptional.get();
//                existingCourse.setCourse_name(course.getCourse_name());
//                existingCourse.setCourse_semester(course.getCourse_semester());
//                existingCourse.setDescription(course.getDescription());
//                existingCourse.setStudent(student);
//                courseServices.updateCourseByStudent(existingCourse, courseId);
//            }
//        }
//    }
//
//    @DeleteMapping(path = "student/{studentId}/course/{courseId}")
//    public void deleteCourseToStudent(@PathVariable Integer courseId){
//        courseServices.deleteCourseByStudent(courseId);
//    }
//



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
