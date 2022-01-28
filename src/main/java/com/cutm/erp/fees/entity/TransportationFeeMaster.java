package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transportation_fee_master")
public class TransportationFeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportationFeeMasterId;
    private Double feePerYear;
    private int academicYear;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date validationDate;

    @OneToOne(targetEntity = RouteSet.class)
    @JoinColumn(name = "route_set_id")
    private RouteSet route;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    public int getTransportationFeeMasterId() {
        return transportationFeeMasterId;
    }

    public Double getFeePerYear() {
        return feePerYear;
    }

    public void setFeePerYear(Double feePerYear) {
        this.feePerYear = feePerYear;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public int getRouteId() {
        return route.getRouteSetId();
    }

    public void setRoute(RouteSet route) {
        this.route = route;
    }

    public int getCampusId() {
        return campus.getCampusId();
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}