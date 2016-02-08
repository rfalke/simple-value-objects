package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5272209944987032006L;

    public String street;
    public String houseNumber;
    public String zipCode;
    public String city;
}
