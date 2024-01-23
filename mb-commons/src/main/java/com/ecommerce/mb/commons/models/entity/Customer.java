package com.ecommerce.mb.commons.models.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql = "UPDATE customer SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String firstName;
	private String numberPhone;
	private String lastName;
	private Long idUser;
	private LocalDate dayOfBirth;
	private String nationalityNative;
	private String birthPlace;
	private String imageProfile;

	@OneToMany()
	private List<Order> budget;
	@OneToOne
	private Address adress;

	@Column(name = "soft_delete")
	private Boolean softDelete = Boolean.FALSE;

	@Column(name = "created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private LocalDateTime created_at;

	@Column(name = "updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private LocalDateTime updated_at;

	@PrePersist
	public void prePersist() {
		created_at = LocalDateTime.now();
		updated_at = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		updated_at = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	public Boolean getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(Boolean softDelete) {
		this.softDelete = softDelete;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Order> getBudget() {
		return budget;
	}

	public void setBudget(List<Order> budget) {
		this.budget = budget;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Customer(Long id, String dni, String firstName, String numberPhone, String lastName, Long idUser,
			LocalDate dayOfBirth, String nationalityNative, String birthPlace, String imageProfile, List<Order> budget,
			Address adress, Boolean softDelete, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.dni = dni;
		this.firstName = firstName;
		this.numberPhone = numberPhone;
		this.lastName = lastName;
		this.idUser = idUser;
		this.dayOfBirth = dayOfBirth;
		this.nationalityNative = nationalityNative;
		this.birthPlace = birthPlace;
		this.imageProfile = imageProfile;
		this.budget = budget;
		this.adress = adress;
		this.softDelete = softDelete;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Customer() {
		super();
	}

}