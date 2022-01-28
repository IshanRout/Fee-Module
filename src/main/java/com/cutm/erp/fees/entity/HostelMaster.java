package com.cutm.erp.fees.entity;
import javax.persistence.*;

@Entity
@Table(name = "hostel_master")
public class HostelMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelId;
    private String hostelName;

    @ManyToOne(targetEntity = Campus.class)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    public int getHostelId() {
        return hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public Campus getCampus() {
        return campus;
    }
}