package de.codecentric.demo.simple.value.objects.hibernate.entities;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class HibernateNormalTest {

    @Test
    public void testPersist() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple-value-objects");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertNotNull(entityManager);

        entityManager.getTransaction().begin();
        Company company = createCompany();
        company = entityManager.merge(company);
        entityManager.getTransaction().commit();
        assertNotNull(company.getId());
    }

    private Company createCompany() {
        Address companyAddress = new Address();
        companyAddress.setStreet("Ritterstr.");
        companyAddress.setHouseNumber("11");
        companyAddress.setZipCode("10969");
        companyAddress.setCity("Berlin");
        Address generalCustomerAddress = new Address();
        generalCustomerAddress.setStreet("Friedrichstraße");
        generalCustomerAddress.setHouseNumber("43-45");
        generalCustomerAddress.setZipCode("10117");
        generalCustomerAddress.setCity("Berlin");

        Company company = new Company();
        company.setName("Example Inc.");
        company.setCompanyAddress(companyAddress);

        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customer.setFirstName(UUID.randomUUID().toString());
            customer.setLastName(UUID.randomUUID().toString());
            customer.setCustomerAddress(generalCustomerAddress);
            customer.setCompany(company);
            company.getCustomers().add(customer);
        }
        return company;
    }
}
