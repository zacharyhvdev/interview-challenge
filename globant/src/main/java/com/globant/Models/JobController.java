package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    private static JobService jobService;

    @Autowired

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public static Job getJob(@RequestParam(value = "id", defaultValue = "1") int id) {
        return jobService.getJob(id);
    }

    @PostMapping
    public static Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PostMapping("migrate_job")
    public static ResponseEntity<String> migrateJob() throws IOException {
        return jobService.migrateJob("C:\\Users\\z.hernandez.valverde\\Documents\\Prueba Tecnica\\prueba data\\prueba data\\jobs.csv");
    }
}
