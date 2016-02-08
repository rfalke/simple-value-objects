package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Company extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8492591792351085610L;

    private String name;

    private Address companyAddress;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Company() {
        this.customers = new ArrayList<>();
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final Address getCompanyAddress() {
        return companyAddress;
    }

    public final void setCompanyAddress(final Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public final List<Customer> getCustomers() {
        return customers;
    }

    public final void setCustomers(final List<Customer> customers) {
        this.customers = customers;
    }

}
