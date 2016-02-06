package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1373565100996488402L;

    public final String street;
    public final String houseNumber;
    public final String zipCode;
    public final String city;

    @JsonCreator
    public Address(@JsonProperty("street") String street,
                   @JsonProperty("houseNumber") String houseNumber,
                   @JsonProperty("zipCode") String zipCode,
                   @JsonProperty("city") String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
}
