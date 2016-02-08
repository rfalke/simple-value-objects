package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -112604491984789277L;

    public final String firstName;
    public final String lastName;
    public final Address customerAddress;
    @ManyToOne
    public final Company company;

    protected Customer() {
        this.firstName = null;
        this.lastName = null;
        this.customerAddress = null;
        this.company = null;
    }

    public Customer(final String firstName, final String lastName, final Address address, final Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = address;
        this.company = company;
    }
}
