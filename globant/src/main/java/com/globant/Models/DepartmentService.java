package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
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
}
