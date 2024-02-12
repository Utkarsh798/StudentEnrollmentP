package com.example.EnrollmentNew.Enroll;

import com.example.EnrollmentNew.Course.Course;
import com.example.EnrollmentNew.Course.CourseRepository;
import com.example.EnrollmentNew.Student.Student;
import com.example.EnrollmentNew.Student.StudentRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollServices {

    @Autowired
    EnrollRepository enrollRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public void addCourseToStudent(Integer studentId, Integer courseId) {
        // Fetch the student and course entities from their respective repositories
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        // Check if both student and course exist
        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Student student = studentOptional.get();
            Course course = courseOptional.get();

            // Create a new enrollment
            Enroll enroll = new Enroll(student, course);

            // Save the enrollment
            enrollRepository.save(enroll);
        }
    }

    public void dropCourseFromStudent(Integer studentId, Integer courseId) {
        Optional<Enroll> enrollOptional = enrollRepository.findByStudentIdAndCourseId(studentId,courseId);
        if(enrollOptional.isPresent()){
            enrollRepository.delete(enrollOptional.get());
        }
    }


    public List<Course> getAllCourseStudentEnrolled(Integer studentId) {
        List<Course> courses = new ArrayList<>();

        // Retrieve enrollments associated with the specified student ID
        List<Enroll> enrollments = enrollRepository.findByStudentId(studentId);

        // Extract courses from the enrollments
        for (Enroll enrollment : enrollments) {
            courses.add(enrollment.getCourse());
        }
        return courses;
    }


    public List<Student> getStudentsEnrolledCourse(Integer courseId) {

        // Retrieve enrollments associated with the specified course ID
        List<Enroll> enrollments = enrollRepository.findByCourseId(courseId);

        List<Student> enrolledStudents = new ArrayList<>();

        // Extract students from the enrollments
        for (Enroll enrollment : enrollments) {
            enrolledStudents.add(enrollment.getStudent());
        }

        return enrolledStudents;

    }

    public Integer getTotalStudentEnrolledInCourse(Integer courseId) {
        return enrollRepository.countByCourseId(courseId);
    }

    public void dropStudentFromCourse(Integer courseId, Integer studentId) {
        Enroll enrollment = enrollRepository.findByCourseIdAndStudentId(courseId, studentId);

        // If the enrollment exists, delete it
        if (enrollment != null) {
            enrollRepository.delete(enrollment);
        } else {
            // Handle the case where enrollment is not found
            throw new RuntimeException("Enrollment not found!");
        }
    }
}
