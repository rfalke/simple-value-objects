package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -112604491984789277L;

    private String firstName;
    private String lastName;
    private Address customerAddress;
    @ManyToOne
    private Company company;

    protected Customer() {
        // empty
    }

    public Customer(final String firstName, final String lastName, final Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = address;
    }
}
