package com.example.AUCARegSystem.controller;


import com.example.AUCARegSystem.model.Teacher;
import com.example.AUCARegSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        Optional<Teacher> existingTeacherOptional = teacherRepository.findById(id);
        if (existingTeacherOptional.isPresent()) {
            Teacher existingTeacher = existingTeacherOptional.get();
            existingTeacher.setName(updatedTeacher.getName());
            existingTeacher.setRole(updatedTeacher.getRole());
            teacherRepository.save(existingTeacher);
            return ResponseEntity.ok(existingTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

