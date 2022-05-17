package com.rle.wedoogift.deposit;

import java.util.Date;

public class Deposit {

    private String type;
    private String companyName;
    private int value;
    private Date dateOfExpiration;


    public Deposit() {
    }

    public Deposit(String type, String companyName, int value, Date dateOfExpiration) {
        this.type = type;
        this.companyName = companyName;
        this.value = value;
        this.dateOfExpiration = dateOfExpiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "type='" + type + '\'' +
                ", companyName='" + companyName + '\'' +
                ", value=" + value +
                ", dateOfExpiration=" + dateOfExpiration +
                '}';
    }
}
