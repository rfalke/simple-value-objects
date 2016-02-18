package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5272209944987032006L;

    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;

    protected Address() {
        // empty
    }

    public Address(final String street, final String houseNumber, final String zipCode, final String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
}
