package com.globant.Models.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HiredEmployeewithIDs {

    private int id;

    private String name;

    private LocalDateTime datetime;
    private int department_id;

    private int job_id;


    public HiredEmployeewithIDs() {
    }
    public HiredEmployeewithIDs(int id, String name, LocalDateTime datetime, int department_id, int job_id) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
        this.department_id = department_id;
        this.job_id = job_id;
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

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
