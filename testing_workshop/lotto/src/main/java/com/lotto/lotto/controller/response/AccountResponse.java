package com.lotto.lotto.controller.response;

import java.util.Objects;

public class AccountResponse {

    private String userName;
    private String password;
    private int salary;

    public AccountResponse() {
    }

    public AccountResponse(String userName, String password, int salary) {
        this.userName = userName;
        this.password = password;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountResponse that = (AccountResponse) o;
        return salary == that.salary &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, password, salary);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
