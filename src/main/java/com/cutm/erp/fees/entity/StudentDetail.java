package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_detail")
public class StudentDetail {
    @Id
    private int studentId;
    private String registrationNumber;
    private int academicYear;
    private int YearOfJoining;
    @Enumerated(EnumType.ORDINAL)
    private StudentType studentType;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(targetEntity = Campus.class)
    @JoinColumn(name="campus_id")
    private Campus campus;

    @OneToOne(targetEntity = Programme.class)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @OneToOne(targetEntity = Branch.class)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public int getStudentId() {
        return studentId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public int getYearOfJoining() {
        return YearOfJoining;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public User getUser() {
        return user;
    }

    public String getCampus() {
        return campus.getCampusName();
    }

    public String getProgramme() {
        return programme.getProgrammeName();
    }

    public String getBranch() {
        return branch.getBranchName();
    }
}