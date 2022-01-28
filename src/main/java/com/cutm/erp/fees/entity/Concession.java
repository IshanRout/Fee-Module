package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "concession")
public class Concession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int concessionId;

    @ManyToOne(targetEntity = StudentDetail.class)
    @JoinColumn(name = "student_id")
    private StudentDetail studentDetail;

    private     String  concessionType;
    private     Integer semester;
    private     Integer academicYear;
    private     Double  amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private     Date    generationDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private     Date    availedDate;

    public int getConcessionId() {
        return concessionId;
    }

    public int getStudentDetailId() {
        return studentDetail.getStudentId();
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public String getConcessionType() {
        return concessionType;
    }

    public void setConcessionType(String concessionType) {
        this.concessionType = concessionType;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public Date getAvailedDate() {
        return availedDate;
    }

    public void setAvailedDate(Date availedDate) {
        this.availedDate = availedDate;
    }
}