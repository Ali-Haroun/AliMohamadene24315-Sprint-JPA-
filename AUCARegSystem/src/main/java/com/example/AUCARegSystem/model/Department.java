package com.example.AUCARegSystem.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import  java.util.List;
@Entity
@Table(name = "Depart")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String departmentName, List<Student> students, List<Course> courses, List<Teacher> teachers) {
        this.id = id;
        this.departmentName = departmentName;
        this.students = students;
        this.courses = courses;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}

