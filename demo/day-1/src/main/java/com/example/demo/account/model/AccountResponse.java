package com.example.demo.account.model;

public class AccountResponse {
    private String accountNo;
    private String mobileNo;
    private String name;
    private String accountType;

    public AccountResponse() {
    }

    public AccountResponse(String accountNo, String mobileNo, String name, String accountType) {
        this.accountNo = accountNo;
        this.mobileNo = mobileNo;
        this.name = name;
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
