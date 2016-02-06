package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6898915531892043238L;

    public final String firstName;
    public final String lastName;
    public final Address customerAddress;

    public Customer(String firstName, String lastName, Address customerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
    }
}
