package com.example.EnrollmentNew.Enroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll, Integer> {

    Optional<Enroll> findByStudentIdAndCourseId(Integer studentId, Integer courseId);

    List<Enroll> findByStudentId(Integer studentId);

    List<Enroll> findByCourseId(Integer studentId);

    Integer countByCourseId(Integer courseId);

    @Query("SELECT e FROM Enroll e WHERE e.course.id = :courseId AND e.student.id = :studentId")
    Enroll findByCourseIdAndStudentId(@Param("courseId") Integer courseId, @Param("studentId") Integer studentId);




}
