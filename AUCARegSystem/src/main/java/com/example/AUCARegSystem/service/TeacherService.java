package com.example.AUCARegSystem.service;


import com.example.AUCARegSystem.model.Teacher;
import com.example.AUCARegSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher) {
        Optional<Teacher> existingTeacherOptional = teacherRepository.findById(id);
        if (existingTeacherOptional.isPresent()) {
            Teacher existingTeacher = existingTeacherOptional.get();
            existingTeacher.setName(updatedTeacher.getName());
            existingTeacher.setRole(updatedTeacher.getRole());
            teacherRepository.save(existingTeacher);
            return Optional.of(existingTeacher);
        } else {
            return Optional.empty();
        }
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
