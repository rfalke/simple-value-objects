package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

    private static final long serialVersionUID = -7531923832214468716L;

    public final String name;
    public final Address companyAddress;
    public final List<Customer> customers;

    @JsonCreator
    public Company(@JsonProperty("name") String name,
                   @JsonProperty("companyAddress") Address companyAddress,
                   @JsonProperty("customers") List<Customer> customers) {
        this.name = name;
        this.companyAddress = companyAddress;
        this.customers = customers;
    }
}
