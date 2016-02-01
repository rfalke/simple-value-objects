package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 6898915531892043238L;

	private String firstName;
	private String lastName;
	private Address customerAddress;

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public final Address getCustomerAddress() {
		return customerAddress;
	}

	public final void setCustomerAddress(final Address customerAddress) {
		this.customerAddress = customerAddress;
	}
}
