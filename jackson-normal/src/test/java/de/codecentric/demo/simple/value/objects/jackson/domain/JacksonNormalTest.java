package de.codecentric.demo.simple.value.objects.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JacksonNormalTest {

    private static final String CITY = "Berlin";

    public Company createDummyObjects() {
        Address companyAddress = new Address();
        companyAddress.setStreet("Ritterstr.");
        companyAddress.setHouseNumber("11");
        companyAddress.setZipCode("10969");
        companyAddress.setCity(CITY);
        Address generalCustomerAddress = new Address();
        generalCustomerAddress.setStreet("Friedrichstraße");
        generalCustomerAddress.setHouseNumber("43-45");
        generalCustomerAddress.setZipCode("10117");
        generalCustomerAddress.setCity(CITY);

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

    @Test
    public void serializeTest() {
        ObjectMapper mapper = new ObjectMapper();
        Company company = createDummyObjects();
        try {
            // mapper.writeValue(File.createTempFile("serializeTest", "json"),
            // company);
            final String json = mapper.writeValueAsString(company);
            assertTrue(json.contains(CITY));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserializeTest() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            final String jsonString = "{\"name\":\"Example Inc.\",\"companyAddress\":{\"street\":\"Ritterstr.\",\"houseNumber\":\"11\",\"zipCode\":\"10969\",\"city\":\"Berlin\"},\"customers\":["
                    + "{\"firstName\":\"8f945e9a\",\"lastName\":\"c8db4c20\",\"customerAddress\":{\"street\":\"Friedrichstraße\",\"houseNumber\":\"43-45\",\"zipCode\":\"10117\",\"city\":\"Berlin\"}}"
                    + ",{\"firstName\":\"02d3ac95\",\"lastName\":\"b584d3ee\",\"customerAddress\":{\"street\":\"Friedrichstraße\",\"houseNumber\":\"43-45\",\"zipCode\":\"10117\",\"city\":\"Berlin\"}}"
                    + ",{\"firstName\":\"7c9b6e1f\",\"lastName\":\"c10cf6ce\",\"customerAddress\":{\"street\":\"Friedrichstraße\",\"houseNumber\":\"43-45\",\"zipCode\":\"10117\",\"city\":\"Berlin\"}}"
                    + ",{\"firstName\":\"6cdd3e92\",\"lastName\":\"4dd2f501\",\"customerAddress\":{\"street\":\"Friedrichstraße\",\"houseNumber\":\"43-45\",\"zipCode\":\"10117\",\"city\":\"Berlin\"}}"
                    + ",{\"firstName\":\"01d99778\",\"lastName\":\"eea68498\",\"customerAddress\":{\"street\":\"Friedrichstraße\",\"houseNumber\":\"43-45\",\"zipCode\":\"10117\",\"city\":\"Berlin\"}}]}";
            Company companyObject = mapper.readValue(jsonString, Company.class);
            assertEquals(CITY, companyObject.getCompanyAddress().getCity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
