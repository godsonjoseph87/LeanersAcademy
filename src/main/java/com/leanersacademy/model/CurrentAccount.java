package com.leanersacademy.model;

public class CurrentAccount extends Accounts{

    private double overdraftAmount = 0;

    public CurrentAccount(double initialBalance, double overdraftAmount){
        super (initialBalance); //invoke constructor present in parent class.
        this.overdraftAmount = overdraftAmount;
    }

    public CurrentAccount(double initialBalance){
        this (initialBalance, 0.0); //invoke constructor present in same class
    }

    public boolean withdraw(double amount) {
        boolean result = true;
        if ( balance < amount ) {
            double overdraftNeeded = amount - balance ;
            if ( overdraftAmount < overdraftNeeded ){
                result = false;
            }else {
                balance = 0.0;
                overdraftAmount -= overdraftNeeded;
            }
        }else {
            balance -= amount;
        }
        return  result;
    }
}




