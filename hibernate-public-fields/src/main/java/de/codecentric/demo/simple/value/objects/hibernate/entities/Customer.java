package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -112604491984789277L;

    public String firstName;
    public String lastName;
    public Address customerAddress;
    @ManyToOne
    public Company company;
}
