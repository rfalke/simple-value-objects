package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

    private static final long serialVersionUID = -7531923832214468716L;

    public final String name;
    public final Address companyAddress;
    public final List<Customer> customers;

    public Company(String name, Address companyAddress, List<Customer> customers) {
        this.name = name;
        this.companyAddress = companyAddress;
        this.customers = customers;
    }
}
