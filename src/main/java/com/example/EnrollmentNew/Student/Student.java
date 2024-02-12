package com.example.EnrollmentNew.Student;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
    private String major;

    public Student() {
    }

    public Student(Integer id, String name, String email, LocalDate dob, String major) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.major = major;
    }

    public Student(String name, String email, LocalDate dob, String major) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.major = major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
