package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1373565100996488402L;

    public final String street;
    public final String houseNumber;
    public final String zipCode;
    public final String city;

    public Address(String street, String houseNumber, String zipCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
}
