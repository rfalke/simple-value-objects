package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6898915531892043238L;

    public final String firstName;
    public final String lastName;
    public final Address customerAddress;

    @JsonCreator
    public Customer(@JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName,
                    @JsonProperty("customerAddress") Address customerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
    }
}
