package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
    private List<Customer> customers = new ArrayList<>();

    public Company() {
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(final Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(final List<Customer> customers) {
        this.customers = customers;
    }

}
