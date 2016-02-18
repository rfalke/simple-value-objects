package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1373565100996488402L;

    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;

    public Address() {
        // required
    }

    public Address(final String street, final String houseNumber, final String zipCode, final String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
}
