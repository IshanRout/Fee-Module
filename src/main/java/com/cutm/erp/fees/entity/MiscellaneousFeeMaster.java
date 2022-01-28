package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "miscellaneous_fee_master")
public class MiscellaneousFeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int miscellaneousFeeId;

    @OneToOne(targetEntity = MiscellaneousHead.class)
    @JoinColumn(name = "miscellaneous_fee_head_id")
    private MiscellaneousHead miscellaneousHead;

    private int academicYear;
    private int semester;
    private double amount;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name ="campus_id")
    private Campus campus;

    @OneToOne(targetEntity = Programme.class)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @OneToOne(targetEntity = Branch.class)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public int getMiscellaneousFeeId() {
        return miscellaneousFeeId;
    }

    public int getMiscellaneousHeadId() {
        return miscellaneousHead.getMiscellaneousHeadId();
    }

    public void setMiscellaneousHead(MiscellaneousHead miscellaneousHead) {
        this.miscellaneousHead = miscellaneousHead;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCampusId() {
        return campus.getCampusId();
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

    public int getBranchId() {
        return branch.getBranchId();
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}