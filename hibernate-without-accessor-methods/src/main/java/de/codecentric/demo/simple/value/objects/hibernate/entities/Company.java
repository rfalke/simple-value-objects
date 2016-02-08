package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Company extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8492591792351085610L;

    private String name;
    private Address companyAddress;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Customer> customers;

    protected Company() {
        // empty
    }

    public Company(final String name, final Address address, final Customer... customers) {
        this.name = name;
        this.companyAddress = address;
        this.customers = Arrays.asList(customers);
    }
}
