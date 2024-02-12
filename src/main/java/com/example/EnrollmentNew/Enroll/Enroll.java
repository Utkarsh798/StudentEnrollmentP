package com.example.EnrollmentNew.Enroll;

import com.example.EnrollmentNew.Course.Course;
import com.example.EnrollmentNew.Student.Student;
import jakarta.persistence.*;

@Entity
@Table
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    public Enroll() {
    }

    public Enroll(Integer id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Enroll(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
