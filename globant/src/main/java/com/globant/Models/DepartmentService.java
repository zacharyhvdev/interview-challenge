package com.globant.Models;

import com.globant.BusinessLogic.ReadFromCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartment(int id) {
        return departmentRepository.findAll();
    }

    public ResponseEntity<String> addDepartment(Department department) {
        departmentRepository.save(department);

        return new ResponseEntity<>("Department added successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> migrateDepartment(String file_name) throws IOException {

        ReadFromCSV readFromCSV = new ReadFromCSV();
        List<Department> departments = ReadFromCSV.LoadCSVtoDepartment(file_name);

        departmentRepository.saveAll(departments);
        return new ResponseEntity<>("Department migrated successfully", HttpStatus.OK);
    }
}
