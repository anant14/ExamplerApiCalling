package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class Address {

    String  street;
    String city;

    public Address(String street, String city) {
        this.street = street;

        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
}
