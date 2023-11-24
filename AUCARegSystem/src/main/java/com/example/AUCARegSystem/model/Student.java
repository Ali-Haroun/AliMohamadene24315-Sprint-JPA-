package com.example.AUCARegSystem.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name= "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer semester;
    private Date registration_date;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, Integer semester, Date registration_date, Department department, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.registration_date = registration_date;
        this.department = department;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}

