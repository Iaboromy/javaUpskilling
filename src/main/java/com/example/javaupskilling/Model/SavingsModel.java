package com.example.javaupskilling.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_savings")
public class SavingsModel {

    @Id
    private long id;

    private String accountNumber;
    private String accountType;
    private String availableBalance;

    public SavingsModel(){
        super();
    }

    public SavingsModel(long id, String accountNumber, String accountType, String availableBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
    }

    public SavingsModel(String accountNumber, String accountType, String availableBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }
}
