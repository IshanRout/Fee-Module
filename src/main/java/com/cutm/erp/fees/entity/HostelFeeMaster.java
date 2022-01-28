package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hostel_fee_master")
public class HostelFeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelFeeMasterId;

    @Enumerated(EnumType.ORDINAL)
    private RoomCategory roomCategory;
    private int academicYear;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date feeFrom;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date feeUpTo;
    private double fee;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date dueDate;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @OneToOne(targetEntity = Programme.class)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    public int getHostelFeeMasterId() {
        return hostelFeeMasterId;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public Date getFeeFrom() {
        return feeFrom;
    }

    public void setFeeFrom(Date feeFrom) {
        this.feeFrom = feeFrom;
    }

    public Date getFeeUpTo() {
        return feeUpTo;
    }

    public void setFeeUpTo(Date feeUpTo) {
        this.feeUpTo = feeUpTo;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
}