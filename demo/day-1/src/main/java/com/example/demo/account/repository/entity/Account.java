package com.example.demo.account.repository.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String accountId;
    private String mobileNo;
    private String name;
    private String accountType;

    public Account() {
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
