package com.cutm.erp.fees.entity;

import javax.persistence.*;

@Entity
@Table(name = "miscellaneous_head")
public class MiscellaneousHead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int miscellaneousHeadId;
    private String headName;
    private boolean oneTimePayment;

    public int getMiscellaneousHeadId() {
        return miscellaneousHeadId;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public boolean isOneTimePayment() {
        return oneTimePayment;
    }

    public void setOneTimePayment(boolean oneTimePayment) {
        this.oneTimePayment = oneTimePayment;
    }
}