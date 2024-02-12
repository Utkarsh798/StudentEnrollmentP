package com.example.EnrollmentNew.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    //query to get courses related to specific student

//    @Query("SELECT c FROM Course c WHERE c.student.id = :studentId AND c.id = :courseId")
//    Optional<Course> findCourseByStudentAndId(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
//
//    @Query("SELECT c FROM Course c WHERE c.student.id = :studentId")
//    List<Course> findAllByStudentId(@Param("studentId") Integer studentId);


}
