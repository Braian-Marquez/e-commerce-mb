package com.ecommerce.mb.auth.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRequest {

	@NotBlank(message = "First name can not be empty")
	private String firstName;

	@NotBlank(message = "Last name can not be empty")
	private String lastName;

	@NotBlank(message = "Email can not be empty")
	@Email(message = "Email is not valid")
	private String email;

	@Size(min = 8)
	private String password;

	private String dni;

	private AddressRequest address;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public void setAddress(AddressRequest address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", dni=" + dni + ", adress=" + address.toString() + "]";
	}

}
