package com.cutm.erp.fees.entity;

import javax.persistence.*;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private long phoneNumber;
    private String emailId;
    private String userPassword;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Role getRole() {
        return role;
    }
}