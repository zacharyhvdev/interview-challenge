package com.globant.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String job;

    @ManyToOne(fetch = FetchType.LAZY)
    private HiredEmployee hiredEmployees;


    public Job() {
    }
    public Job(int id, String job) {
        this.id = id;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
