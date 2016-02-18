package de.codecentric.demo.simple.value.objects.jackson.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonWithoutAccessorMethodsTest {

	@Test
	public void testRoundTrip() throws Exception {
		Company initialValue = createCompany();
		final String firstJson = toJsonString(initialValue);
		Company oneRoundTrip = fromJsonString(firstJson);
		assertReflectionEquals(initialValue, oneRoundTrip);

		final String secondJson = toJsonString(oneRoundTrip);
		assertThat(secondJson, is(firstJson));
	}

	public Company createCompany() {
		Address companyAddress = new Address("Ritterstr.", "11", "10969", "Berlin");
		Address generalCustomerAddress = new Address("Friedrichstraße", "43-45", "10117", "Berlin");

		List<Customer> customers = new ArrayList<Customer>();
		for (int i = 0; i < 5; i++) {
			Customer customer = new Customer(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
					generalCustomerAddress);
			customers.add(customer);
		}
		return new Company("Example Inc.", companyAddress, customers);
	}

	private String toJsonString(Company company) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		// mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return mapper.writeValueAsString(company);
	}

	private Company fromJsonString(String jsonString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		// mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return mapper.readValue(jsonString, Company.class);
	}
}
