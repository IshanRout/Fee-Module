package com.cutm.erp.fees.entity;

import javax.persistence.*;
@Entity
@Table(name="academic_fee")
public class AcademicFeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int academicFeeId;
    private int batchYear;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @ManyToOne(targetEntity = Programme.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "programme_id")
    private Programme programme;


    @ManyToOne(targetEntity = Branch.class,fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name="branch_id")
    private Branch branch;

    double tuitionFeePerYear;
    double examFeePerYear;

    public int getAcademicFeeId() {
        return academicFeeId;
    }

    public int getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(int batchYear) {
        this.batchYear = batchYear;
    }

    public Integer getCampusId() {
        return campus.getCampusId();
    }

    public String  getCampusName() {
        return campus.getCampusName();
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getProgrammeId() {
        return programme.getProgrammeId();
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Integer getBranchId() {
        return branch.getBranchId();
    }

    public String getBranchName(){return branch.getBranchName();}

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public double getTuitionFeePerYear() {
        return tuitionFeePerYear;
    }

    public void setTuitionFeePerYear(double tuitionFeePerYear) {
        this.tuitionFeePerYear = tuitionFeePerYear;
    }

    public double getExamFeePerYear() {
        return examFeePerYear;
    }

    public void setExamFeePerYear(double examFeePerYear) {
        this.examFeePerYear = examFeePerYear;
    }
}