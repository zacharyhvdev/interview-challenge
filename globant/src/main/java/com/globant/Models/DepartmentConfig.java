package com.globant.Models;

import com.globant.BusinessLogic.ReadFromCSV;
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

            ReadFromCSV readFromCSV = new ReadFromCSV();
            List<Job> jobs = ReadFromCSV.LoadCSVtoJob("C:\\Users\\z.hernandez.valverde\\Documents\\Prueba Tecnica\\prueba data\\prueba data\\departments.csv");
            for (Job job : jobs) {
                System.out.println(job.getId());
            }
        };
    }
}
