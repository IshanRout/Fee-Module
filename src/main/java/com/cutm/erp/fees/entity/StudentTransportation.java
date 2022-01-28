package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_transportation")
public class StudentTransportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentTransportationId;

    @ManyToOne(targetEntity = StudentDetail.class)
    @JoinColumn(name = "student_id")
    private StudentDetail student;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateOfIssue;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date validationDate;

    @ManyToOne(targetEntity = TransportationMaster.class)
    @JoinColumn(name = "transportation_id")
    private TransportationMaster transportationMaster;

    @ManyToOne(targetEntity = TransportPickupLocation.class)
    @JoinColumn(name = "transport_pickup_id")
    private TransportPickupLocation transportPickupLocation;

    public int getStudentTransportationId() {
        return StudentTransportationId;
    }

    public void setStudentTransportationId(int StudentTransportationId) {
        this.StudentTransportationId = StudentTransportationId;
    }

    public int getStudentId() {
        return student.getStudentId();
    }

    public void setStudent(StudentDetail student) {
        this.student = student;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public int getTransportationMasterId() {
        return transportationMaster.getTransportationId();
    }

    public void setTransportationMaster(TransportationMaster transportationMaster) {
        this.transportationMaster = transportationMaster;
    }

    public int getTransportPickupLocationId() {
        return transportPickupLocation.getTransportPickupId();
    }

    public void setTransportPickupLocation(TransportPickupLocation transportPickupLocation) {
        this.transportPickupLocation = transportPickupLocation;
    }
}