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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Job job;

    public HiredEmployee(int id, String name, LocalDateTime datetime, Job job, Department department) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
        this.job = job;
        this.department = department;
    }

    public HiredEmployee() {

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
