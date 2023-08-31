package com.globant.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    // id del departamento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    // nombre del departamento

    @Column(nullable = false)
    public String department;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<HiredEmployee> hiredEmployee;

    public Department(int id, String department) {
        this.id = id;
        this.department = department;
    }

    public List<HiredEmployee> getHiredEmployee() {
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
