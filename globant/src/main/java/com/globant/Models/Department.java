package com.globant.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="department")
public class Department {

    // id del departamento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    // nombre del departamento
    public String department;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private ArrayList<HiredEmployee> hiredEmployee;

    public Department(int id, String department) {
        this.id = id;
        this.department = department;
    }

    public ArrayList<HiredEmployee> getHiredEmployee() {
        return hiredEmployee;
    }

    public void setHiredEmployee(ArrayList<HiredEmployee> hiredEmployee) {
        this.hiredEmployee = hiredEmployee;
    }

    public Department() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
