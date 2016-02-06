package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1373565100996488402L;

    public String street;
    public String houseNumber;
    public String zipCode;
    public String city;
}
