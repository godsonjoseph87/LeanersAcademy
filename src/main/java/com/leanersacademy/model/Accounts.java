package com.leanersacademy.model;

public class Accounts {
    protected double balance = 500.00;

    //constructor : name == class name
    protected Accounts(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    private String id = "8136958555";
    private String type;
    private double interestRate;
    private double overdraftAmount;
    private int customerId;

    public String getId(){
        return id;
    }

    public String gettype(){return type;}

    public double getInterestRate(){return interestRate;}

    public double getOverdraftAmount(){return overdraftAmount;}

    public int getCustomerId(){return customerId;}

    public String settype(String type){
        this.type = type;
        return type;
    }

    public double setInterestRate(double interestRate){
        this.interestRate = interestRate;
        return interestRate;
    }

    public double setOverDraftAmount(double oda){
        this.overdraftAmount = oda;
        return overdraftAmount;
    }

    public int setCustomerId(int customerId){
        this.customerId = customerId;
        return customerId;
    }

    public String setId(String id){
        this.id = id;
        return id;
    }


    public boolean withdraw(double amount) {
        if  ( amount <= balance ) {
            balance = balance - amount;
            return  true;
        }else {
//        System.out.println("insufficient balance");
            return false;
        }
    }
    public  boolean deposit(double amount ){
        //update the balance
        balance = balance + amount;
        return true ;
    }
}
