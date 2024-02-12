package com.example.EnrollmentNew.Course;

import com.example.EnrollmentNew.Student.Student;
import jakarta.persistence.*;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String course_name;
    private String course_semester;
    private String description;

    public Course() {
    }

    public Course(Integer id, String course_name, String course_semester, String description) {
        this.id = id;
        this.course_name = course_name;
        this.course_semester = course_semester;
        this.description = description;
    }

    public Course(String course_name, String course_semester, String description) {
        this.course_name = course_name;
        this.course_semester = course_semester;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_semester() {
        return course_semester;
    }

    public void setCourse_semester(String course_semester) {
        this.course_semester = course_semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

