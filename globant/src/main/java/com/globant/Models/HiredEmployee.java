package com.globant.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "hired_employee")
public class HiredEmployee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true)
    private int id;
    private String name;
    private LocalDateTime datetime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ArrayList<Department> departments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ArrayList<Job> jobs;

    public HiredEmployee(int id, String name, LocalDateTime datetime, Department department, Job job) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
    }

    public HiredEmployee() {

    }


    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

}
