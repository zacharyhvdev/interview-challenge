package com.globant.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
