package de.codecentric.demo.simple.value.objects.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Test;

import de.codecentric.demo.simple.value.objects.hibernate.entities.Address;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Company;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Customer;

public class HibernateFinalPublicFieldsTest {

    @Test
    public void testPersist() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple-value-objects");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertNotNull(entityManager);

        entityManager.getTransaction().begin();
        Company company = createCompany();
        company = entityManager.merge(company);
        entityManager.getTransaction().commit();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);
        CriteriaQuery<Company> select = cq.select(cq.from(Company.class));
        TypedQuery<Company> q = entityManager.createQuery(select);
        List<Company> companies = q.getResultList();

        assertEquals("Example Inc.", companies.get(0).name);
    }

    private Company createCompany() {
        Address companyAddress = new Address("Ritterstr.", "11", "10969", "Berlin");
        Address generalCustomerAddress = new Address("Friedrichstraße", "43-45", "10117", "Berlin");
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                    generalCustomerAddress, null));
        }
        Company company = new Company("Example Inc.", companyAddress,
                customers.toArray(new Customer[customers.size()]));
        return company;
    }
}
