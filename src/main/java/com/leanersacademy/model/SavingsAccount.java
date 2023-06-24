package com.leanersacademy.model;

public class SavingsAccount extends Accounts{

    private double interestRate = 0;

    public SavingsAccount(double initialBalance, double interestRate){
        super (initialBalance);
        this.interestRate = interestRate;
    }
}
