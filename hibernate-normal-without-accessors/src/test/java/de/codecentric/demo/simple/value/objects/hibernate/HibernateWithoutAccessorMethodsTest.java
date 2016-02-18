package de.codecentric.demo.simple.value.objects.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.codecentric.demo.simple.value.objects.hibernate.entities.Address;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Company;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Customer;

public class HibernateWithoutAccessorMethodsTest {

    @Test
    public void testPersist() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple-value-objects");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertNotNull(entityManager);

        entityManager.getTransaction().begin();
        Company company = createCompany();
        company = entityManager.merge(company);
        entityManager.getTransaction().commit();
        assertSame(1, entityManager.createNativeQuery("select * from company").getResultList().size());
    }

    private Company createCompany() {
        Address companyAddress = new Address("Ritterstr.", "11", "10969", "Berlin");
        Address generalCustomerAddress = new Address("Friedrichstraße", "43-45", "10117", "Berlin");
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customers.add(
                    new Customer(UUID.randomUUID().toString(), UUID.randomUUID().toString(), generalCustomerAddress));
        }
        Company company = new Company("Example Inc.", companyAddress,
                customers.toArray(new Customer[customers.size()]));
        return company;
    }
    
    @Test
    public void immutabilityTest(){
    	LocalTime now = LocalTime.now();
    	String nowstring = now.toString();
    	// System.out.println(nowstring);
    	
    	LocalTime in15Minutes = now.plusMinutes(15);// creates a new object
    	
    	String nowstringAfterManipulation = now.toString();
    	// System.out.println(nowstringAfterManipulation);// prints the same as the statement above
    	
    	assertEquals(nowstring, nowstringAfterManipulation);
    }
}
