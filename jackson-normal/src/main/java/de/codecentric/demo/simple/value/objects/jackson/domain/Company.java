package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = -7531923832214468716L;

	private String name;
	private Address companyAddress;
	private List<Customer> customers;

	// jackson required a default constructor for deserializen
	public Company() {
		this.customers = new ArrayList<Customer>();
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final Address getCompanyAddress() {
		return companyAddress;
	}

	public final void setCompanyAddress(final Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	public final List<Customer> getCustomers() {
		return customers;
	}

	public final void setCustomers(final List<Customer> customers) {
		this.customers = customers;
	}
}
