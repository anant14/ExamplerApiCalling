package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class User {

    int id;
    String name;
    String username;
    String email;
    Address address;

    public User(int id,String name, String username, String email, Address address) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
