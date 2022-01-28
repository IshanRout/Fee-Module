package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="fee_payment_info")
public class FeePaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feePaymentId;
    private int transactionId;
    private int academicYear;

    @ManyToOne(targetEntity = StudentDetail.class)
    @JoinColumn(name = "student_id")
    private StudentDetail studentDetail;

    @Enumerated(EnumType.ORDINAL)
    private FeeHead feeHead;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy hh:mm:ss")
    private Date timeOfPayment;
    private double amount;
    private String transactionType;
    private String enteredBy;

    public int getFeePaymentId() {
        return feePaymentId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public FeeHead getFeeHead() {
        return feeHead;
    }

    public void setFeeHead(FeeHead feeHead) {
        this.feeHead = feeHead;
    }

    public Date getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(Date timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public int getStudentDetailId() {
        return studentDetail.getStudentId();
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }
}