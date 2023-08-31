package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

        public static DepartmentService departmentService;

        @Autowired
        public DepartmentController(DepartmentService departmentService) {
            this.departmentService = departmentService;
        }

        @GetMapping
        public List<Department> getDepartment(@RequestParam(value = "id", defaultValue = "1") int id) {
            return departmentService.getDepartment(id);
        }

        @PostMapping
        public ResponseEntity<String> addDepartment(@RequestBody Department department) {
            return departmentService.addDepartment(department);
        }

        @PostMapping("migrate_department")
        public ResponseEntity<String> migrateDepartment() throws IOException {
            String file_name = "C:\\Users\\z.hernandez.valverde\\Documents\\Prueba Tecnica\\prueba data\\prueba data\\departments.csv";
            return departmentService.migrateDepartment(file_name);
        }

}
