package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
