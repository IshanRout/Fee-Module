package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fineId;

    @ManyToOne(targetEntity = StudentDetail.class)
    @JoinColumn(name = "student_id")
    private StudentDetail studentDetail;

    private     String  fineType;
    private     Integer semester;
    private     Integer academicYear;
    private     Double  amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private     Date    generationDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private     Date    dueDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private     Date    paidDate;
    private     String  status;

    public int getFineId() {
        return fineId;
    }

    public int getStudentDetailId() {
        return studentDetail.getStudentId();
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public String getFineType() {
        return fineType;
    }

    public void setFineType(String fineType) {
        this.fineType = fineType;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}