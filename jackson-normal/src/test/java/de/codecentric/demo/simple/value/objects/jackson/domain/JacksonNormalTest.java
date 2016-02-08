package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class JacksonNormalTest {

    @Test
    public void testRoundTrip() throws Exception {
        Company initialValue = createCompany();
        final String firstJson = toJsonString(initialValue);
        Company oneRoundTrip = fromJsonString(firstJson);
        assertReflectionEquals(initialValue, oneRoundTrip);

        final String secondJson = toJsonString(oneRoundTrip);
        assertThat(secondJson, is(firstJson));
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
            company.getCustomers().add(customer);
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
