package com.globant.Models;

import com.globant.BusinessLogic.ReadFromCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJob(int id) {
        return jobRepository.findById(id).orElse(null);
    }

    public ResponseEntity<String> migrateJob(String file_name) throws IOException {

        ReadFromCSV readFromCSV = new ReadFromCSV();
        jobRepository.saveAll(ReadFromCSV.LoadCSVtoJob(file_name));

        return new ResponseEntity("Job migrated successfully", HttpStatus.OK);
    }
}
