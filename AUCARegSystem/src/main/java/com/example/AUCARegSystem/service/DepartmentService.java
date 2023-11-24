package com.example.AUCARegSystem.service;


import com.example.AUCARegSystem.model.Department;
import com.example.AUCARegSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);
        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());

            departmentRepository.save(existingDepartment);
            return Optional.of(existingDepartment);
        } else {
            return Optional.empty();
        }
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
