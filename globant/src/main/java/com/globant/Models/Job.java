package com.globant.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(nullable = false)
    private String job;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<HiredEmployee> hiredEmployee;
    public Job() {
    }
    public Job(int id, String job) {
        this.id = id;
        this.job = job;
    }

    public List<HiredEmployee> getHiredEmployee() {
        return hiredEmployee;
    }

    public void setHiredEmployee(List<HiredEmployee> hiredEmployee) {
        this.hiredEmployee = hiredEmployee;
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
