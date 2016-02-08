package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -112604491984789277L;

    private String firstName;

    private String lastName;

    private Address customerAddress;

    @ManyToOne
    private Company company;

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final Address getCustomerAddress() {
        return customerAddress;
    }

    public final void setCustomerAddress(final Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public final Company getCompany() {
        return company;
    }

    public final void setCompany(final Company company) {
        this.company = company;
    }
}
