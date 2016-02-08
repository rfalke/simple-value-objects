package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Company extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8492591792351085610L;

    public String name;
    public Address companyAddress;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    public List<Customer> customers;
}
