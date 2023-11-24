package com.example.AUCARegSystem.service;


import com.example.AUCARegSystem.model.Student;
import com.example.AUCARegSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setSemester(updatedStudent.getSemester());
            existingStudent.setRegistration_date(updatedStudent.getRegistration_date());
            studentRepository.save(existingStudent);
            return Optional.of(existingStudent);
        } else {
            return Optional.empty();
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

