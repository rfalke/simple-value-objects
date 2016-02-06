package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6898915531892043238L;

    public String firstName;
    public String lastName;
    public Address customerAddress;

}
