package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name="programme")
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programmeId;
    private String programmeName;
    private int duration;

    public int getProgrammeId() {
        return programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public int getDuration() {
        return duration;
    }
}