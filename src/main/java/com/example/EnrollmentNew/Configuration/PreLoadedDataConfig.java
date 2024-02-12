package com.example.EnrollmentNew.Configuration;

import com.example.EnrollmentNew.Course.Course;
import com.example.EnrollmentNew.Course.CourseRepository;
import com.example.EnrollmentNew.Student.Student;
import com.example.EnrollmentNew.Student.StudentRepository;
import org.hibernate.boot.archive.internal.JarFileBasedArchiveDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.JULY;

@Configuration
public class PreLoadedDataConfig {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Student Utkarsh =  new Student(
                    "Utkarsh Amin",
                    "utkarshaminamin99@gmail.com",
                    LocalDate.of(1998, JULY, 19),
                    "Spring"
            );

            Student Mihir =  new Student(
                    "Mihir Raj",
                    "mihirraj101@gmail.com",
                    LocalDate.of(1996, JULY, 16),
                    "Fall"
            );



            Course Java = new Course(
                    "Java",
                    "Spring",
                    "This is first class of Java"
            );

            Course Python = new Course(
                    "Python",
                    "Fall",
                    "This is first class of Python"
            );

//            // Set courses for students
//            Utkarsh.getCourses().addAll(List.of(Java,Python));
//            Mihir.getCourses().addAll(List.of(Python));
//
//
//            // Associate students with courses
//            Java.getStudent().addAll(List.of(Utkarsh));
//            Python.getStudent().addAll(List.of(Utkarsh,Mihir));

            studentRepository.saveAll(List.of(Utkarsh, Mihir));
            courseRepository.saveAll(List.of(Java,Python));
        };
    }

}
