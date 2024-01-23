package com.ecommerce.mb.customer.models.request;

import java.time.LocalDate;

public class CustomerRequest {
	private String dni;
	private String firstName;
	private String numberPhone;
	private String lastName;
	private LocalDate dayOfBirth;
	private String nationalityNative;
	private String birthPlace;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getNationalityNative() {
		return nationalityNative;
	}
	public void setNationalityNative(String nationalityNative) {
		this.nationalityNative = nationalityNative;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	
	
}
