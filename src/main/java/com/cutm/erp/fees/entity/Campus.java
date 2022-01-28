package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campusId;
    private String campusName;

    public int getCampusId() {
        return campusId;
    }

    public String getCampusName() {
        return campusName;
    }
}