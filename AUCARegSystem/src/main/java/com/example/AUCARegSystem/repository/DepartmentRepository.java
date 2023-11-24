package com.example.AUCARegSystem.repository;

import com.example.AUCARegSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();
}