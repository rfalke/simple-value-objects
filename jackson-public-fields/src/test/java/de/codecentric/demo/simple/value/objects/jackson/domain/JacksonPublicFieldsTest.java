package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class JacksonPublicFieldsTest {

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

        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customer.firstName = UUID.randomUUID().toString();
            customer.lastName = UUID.randomUUID().toString();
            customer.customerAddress = generalCustomerAddress;
            company.customers.add(customer);
        }
        return company;
    }

    private String toJsonString(Company company) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(company);
    }

    private Company fromJsonString(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, Company.class);
    }
}
