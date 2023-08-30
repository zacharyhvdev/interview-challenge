package com.globant.Models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartmentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            DepartmentRepository repository) {
        return args -> {

//            Department department = new Department(
//                    1,
//                    "Information Technology"
//            );
//
//            repository.saveAll(List.of(department));
        };
    }
}
