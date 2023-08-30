package com.globant.Models;

import jakarta.persistence.*;

@Entity
@Table(name="department")
public class Department {

    // id del departamento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    // nombre del departamento
    public String department;

    @OneToOne(mappedBy = "department", fetch = FetchType.LAZY)
    private HiredEmployee hiredEmployee;


    public Department(int id, String department) {
        this.id = id;
        this.department = department;
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
