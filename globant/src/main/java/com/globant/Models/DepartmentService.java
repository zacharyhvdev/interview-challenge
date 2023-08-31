package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository studentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.studentRepository = departmentRepository;
    }

    public List<Department> getDepartment(int id) {
        return studentRepository.findAll();
    }

    public ResponseEntity<String> addDepartment(Department department) {
        studentRepository.save(department);

        return new ResponseEntity<>("Department added successfully", HttpStatus.OK);
    }
}
