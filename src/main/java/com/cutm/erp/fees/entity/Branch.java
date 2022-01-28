package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    private String branchName;

    @ManyToOne(targetEntity = Programme.class)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Programme getProgramme() {
        return programme;
    }

}