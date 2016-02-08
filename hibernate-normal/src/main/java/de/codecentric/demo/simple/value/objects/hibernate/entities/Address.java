package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5272209944987032006L;

    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;

    public final String getStreet() {
        return street;
    }

    public final void setStreet(final String street) {
        this.street = street;
    }

    public final String getHouseNumber() {
        return houseNumber;
    }

    public final void setHouseNumber(final String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public final String getZipCode() {
        return zipCode;
    }

    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        this.city = city;
    }
}
