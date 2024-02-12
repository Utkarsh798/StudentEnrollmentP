package com.example.EnrollmentNew.Course;

import com.example.EnrollmentNew.Student.Student;
import com.example.EnrollmentNew.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
//
//    public List<Course> getAllCourseByStudent(Integer studentId){
//        return courseRepository.findAllByStudentId(studentId);
//    }
//
//
//    public Optional<Course> getcoursebyStudent(Integer studentId, Integer courseId) {
//        return courseRepository.findCourseByStudentAndId(studentId,courseId);
//    }
//
//    public void addCourseByStudent(Course course) {
//        courseRepository.save(course);
//    }
//
//    public void updateCourseByStudent(Course course, Integer courseId) {
//        courseRepository.save(course);
//    }
//
//
//    public void deleteCourseByStudent(Integer courseId) {
//
//        courseRepository.deleteById(courseId);
//
//    }

    /************************************************* To access All the Course Information *********************/
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public Course getCourse(Integer courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isPresent()){
            return courseOptional.get();
        }
        return null;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }


    public void updateCourse(Course course,Integer courseId) {
        Optional<Course> updateOptionalCourse = courseRepository.findById(courseId);

        if(updateOptionalCourse.isPresent()){
            Course existingCourse = updateOptionalCourse.get();
            // Update the existing course with the new data
            existingCourse.setCourse_name(course.getCourse_name());
            existingCourse.setCourse_semester(course.getCourse_semester());
            existingCourse.setDescription(course.getDescription());

            // Save the updated course
            courseRepository.save(existingCourse);
        }
    }

    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
