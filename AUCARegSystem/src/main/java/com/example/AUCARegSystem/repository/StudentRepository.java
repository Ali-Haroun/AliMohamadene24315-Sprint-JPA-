package com.example.AUCARegSystem.repository;

import com.example.AUCARegSystem.model.Course;
import com.example.AUCARegSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findAll();
     List<Student> findBySemester(Integer semester);
     List<Student> findByDepartmentIdAndSemester(Long departmentId, Integer semester);
     List<Student> findByCoursesIdAndSemester(Long courseId, Integer semester);
     List<Student> findByDepartmentIdAndCoursesIdAndSemester(Long departmentId, Long courseId, Integer semester);
     @Query("SELECT s.courses FROM Student s WHERE s.id = :studentId")
     List<Course> findCoursesByStudentId(Long studentId);
}

