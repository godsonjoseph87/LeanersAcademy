package com.leanersacademy.model;

public class Customer {
    private String firstName;
    private String lastName;

    private Accounts account;

    private Integer id;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Accounts getAccount() {
        return account;
    }

    public int getId() { return id; }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public void setAccount(Accounts account) { // polymorphic argument
        //this keyword refer to current instance (object)
        this.account = account;
    }


}
