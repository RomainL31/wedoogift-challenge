package com.rle.wedoogift.company;

public class Company {

    private String name;
    private float account;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, float account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAccount() {
        return account;
    }

    public void setAccount(float account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}
