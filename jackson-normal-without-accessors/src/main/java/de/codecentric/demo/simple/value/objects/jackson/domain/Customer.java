package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6898915531892043238L;

    private String firstName;
    private String lastName;
    private Address customerAddress;

    public Customer() {
        // required
    }

    public Customer(final String firstName, final String lastName, final Address customerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
    }
}
