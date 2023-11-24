package com.example.AUCARegSystem.service;


import com.example.AUCARegSystem.model.Course;
import com.example.AUCARegSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            existingCourse.setCourseName(updatedCourse.getCourseName());
       existingCourse.setSemester(updatedCourse.getSemester());
            courseRepository.save(existingCourse);
            return Optional.of(existingCourse);
        } else {
            return Optional.empty();
        }
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

