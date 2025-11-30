package com.joe.joepetitions.model;

public class Signature {

    private String name;
    private String email;
    private int phoneNumber;

    // Default constructor for signatures
    public Signature() {

    }
    // Helps add signature details
    public Signature(String name, String email, int number) {
        this.name = name;
        this.email = email;
        this.phoneNumber = number;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
