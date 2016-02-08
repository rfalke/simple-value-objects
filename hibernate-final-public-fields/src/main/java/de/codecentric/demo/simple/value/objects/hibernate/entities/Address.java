package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5272209944987032006L;

    public final String street;
    public final String houseNumber;
    public final String zipCode;
    public final String city;

    protected Address() {
        this.street = null;
        this.houseNumber = null;
        this.zipCode = null;
        this.city = null;
    }

    public Address(final String street, final String houseNumber, final String zipCode, final String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
}
