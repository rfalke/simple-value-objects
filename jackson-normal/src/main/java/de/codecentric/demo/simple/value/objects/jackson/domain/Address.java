package de.codecentric.demo.simple.value.objects.jackson.domain;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1373565100996488402L;

	private String street;
	private String houseNumber;
	private String zipCode;
	private String city;

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(final String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}
}
