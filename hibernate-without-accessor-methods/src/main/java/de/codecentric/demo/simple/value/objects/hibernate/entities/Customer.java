package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -112604491984789277L;

    private String firstName;
    private String lastName;
    private Address customerAddress;
    private String email;
    private boolean emailVerified;
    
    @ManyToOne
    private Company company;

    protected Customer() {
        // empty
    }

    public Customer(final String firstName, final String lastName, final Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = address;
    }
    
    public void moveTo(Address newAddress){
    	
    	customerAddress = newAddress;
    	
    	// TODO further domain logic?
    	
    	// change running orders (not shipped yet)
    	// => other entities -> needs to be placed in service?
    	// => or create event
    	
    }
    
    /*
     * WRONG:
     * customer.setEmail("abc@example.com");
     * customer.setEmailVerified(false);
     * ...
     * customer.setEmailVerified(true);
     * 
     * 
     * RIGHT:
     * customer.changeEmailTo("abc@example.com");
     * ...
     * customer.verifyEmail();
     * 
     */
    
    public void changeEmailTo(String newEmail){
    	email = newEmail;
    	emailVerified = false;
    }
    
    public void verifyEmail(){
    	emailVerified = true;
    }
}
