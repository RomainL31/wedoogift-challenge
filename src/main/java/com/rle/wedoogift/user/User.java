package com.rle.wedoogift.user;


import java.util.List;

import com.rle.wedoogift.deposit.Deposit;

public class User {

    private String name;

    private float account;
    private List<Deposit> wallet;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, float account) {
        this.name = name;
        this.account = account;
    }

    public User(String name, List<Deposit> wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public User(String name, float account, List<Deposit> wallet) {
        this.name = name;
        this.account = account;
        this.wallet = wallet;
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

    public List<Deposit> getWallet() {
        return wallet;
    }

    public void setWallet(List<Deposit> wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", wallet=" + wallet +
                '}';
    }
}
