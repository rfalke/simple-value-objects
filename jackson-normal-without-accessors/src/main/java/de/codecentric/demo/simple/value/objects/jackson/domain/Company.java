package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

    private static final long serialVersionUID = -7531923832214468716L;

    private String name;
    private Address companyAddress;
    private List<Customer> customers;

    public Company() {
        // required
    }

    public Company(final String name, final Address companyAddress, final List<Customer> customers) {
        this.name = name;
        this.companyAddress = companyAddress;
        this.customers = customers;
    }
}
