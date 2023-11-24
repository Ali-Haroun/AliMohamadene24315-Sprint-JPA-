package com.example.AUCARegSystem.controller;


import com.example.AUCARegSystem.model.Course;
import com.example.AUCARegSystem.model.Student;
import com.example.AUCARegSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class  StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(updatedStudent.getName());
          existingStudent.setSemester(updatedStudent.getSemester());
            existingStudent.setRegistration_date(updatedStudent.getRegistration_date());
            studentRepository.save(existingStudent);
            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/semester/{semester}")
    public List<Student> getStudentsBySemester(@PathVariable Integer semester) {
        return studentRepository.findBySemester(semester);
    }
    @GetMapping("/department/{departmentId}/semester/{semester}")
    public List<Student> getStudentsByDepartmentAndSemester(
            @PathVariable Long departmentId,
            @PathVariable Integer semester
    ) {
        return studentRepository.findByDepartmentIdAndSemester(departmentId, semester);
    }
    @GetMapping("/course/{courseId}/semester/{semester}")
    public List<Student> getStudentsByCourseAndSemester(
            @PathVariable Long courseId,
            @PathVariable Integer semester
    ) {
        return studentRepository.findByCoursesIdAndSemester(courseId, semester);
    }
    @GetMapping("/department/{departmentId}/course/{courseId}/semester/{semester}")
    public List<Student> getStudentsByDepartmentCourseAndSemester(
            @PathVariable Long departmentId,
            @PathVariable Long courseId,
            @PathVariable Integer semester
    ) {
        return studentRepository.findByDepartmentIdAndCoursesIdAndSemester(departmentId, courseId, semester);
    }
    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
        return studentRepository.findCoursesByStudentId(studentId);
    }
}


