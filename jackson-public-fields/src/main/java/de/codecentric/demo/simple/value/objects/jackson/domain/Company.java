package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

    private static final long serialVersionUID = -7531923832214468716L;

    public String name;
    public Address companyAddress;
    public List<Customer> customers;

    // jackson required a default constructor for deserializen
    public Company() {
        this.customers = new ArrayList<Customer>();
    }

}
