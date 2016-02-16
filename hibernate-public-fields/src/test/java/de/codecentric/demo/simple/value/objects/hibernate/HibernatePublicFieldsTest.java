package de.codecentric.demo.simple.value.objects.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Assert;
import org.junit.Test;

import de.codecentric.demo.simple.value.objects.hibernate.entities.Address;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Company;
import de.codecentric.demo.simple.value.objects.hibernate.entities.Customer;

public class HibernatePublicFieldsTest {

	@Test
	public void testEntity() {
		EntityManager entityManager = getEntityManager();

		save(entityManager, createCompany());

		List<Company> selectedCompanies = select(entityManager);
		Assert.assertEquals(1, selectedCompanies.size());

		update(entityManager, selectedCompanies.get(0));
		assertEquals("Sample Inc.", select(entityManager).get(0).name);
	}

	private void save(final EntityManager em, final Company company) {
		em.getTransaction().begin();
		em.persist(company);
		em.getTransaction().commit();
	}

	private List<Company> select(final EntityManager em) {
		CriteriaQuery<Company> cq = em.getCriteriaBuilder().createQuery(Company.class);
		CriteriaQuery<Company> select = cq.select(cq.from(Company.class));
		return em.createQuery(select).getResultList();
	}

	private void update(final EntityManager em, final Company company) {
		em.getTransaction().begin();
		company.name = "Sample Inc.";
		em.merge(company);
		em.getTransaction().commit();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple-value-objects");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager);
		return entityManager;
	}

	private Company createCompany() {
		Address companyAddress = new Address();
		companyAddress.street = "Ritterstr.";
		companyAddress.houseNumber = "11";
		companyAddress.zipCode = "10969";
		companyAddress.city = "Berlin";
		Address generalCustomerAddress = new Address();
		generalCustomerAddress.street = "Friedrichstraße";
		generalCustomerAddress.houseNumber = "43-45";
		generalCustomerAddress.zipCode = "10117";
		generalCustomerAddress.city = "Berlin";

		Company company = new Company();
		company.name = "Example Inc.";
		company.companyAddress = companyAddress;

		List<Customer> customers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Customer customer = new Customer();
			customer.firstName = UUID.randomUUID().toString();
			customer.lastName = UUID.randomUUID().toString();
			customer.customerAddress = generalCustomerAddress;
			customer.company = company;
			customers.add(customer);
		}
		company.customers = customers;
		return company;
	}
}
