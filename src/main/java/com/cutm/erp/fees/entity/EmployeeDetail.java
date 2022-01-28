package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeDetail {
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(targetEntity = Campus.class)
    @JoinColumn(name="campus_id")
    private Campus campus;

    @Id
    private int employeeId;
    private int yearOfJoining;
    private String designation;

    public User getUser() {
        return user;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public String getCampus() {
        return campus.getCampusName();
    }
}