package com.ecommerce.mb.commons.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "proof")
public class ProofPayment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private int spId;
    private String barcode;
    private String paymentStatus;
    private String paymentMethod;
    private String description;
    private String externalReference;
    private double amount;
    private String url;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accreditationDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate secondDueDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDate;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getAccreditationDate() {
		return accreditationDate;
	}

	public void setAccreditationDate(LocalDate accreditationDate) {
		this.accreditationDate = accreditationDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getSecondDueDate() {
		return secondDueDate;
	}

	public void setSecondDueDate(LocalDate secondDueDate) {
		this.secondDueDate = secondDueDate;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
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

	public ProofPayment(Long id, Long customerId, int spId, String barcode, String paymentStatus, String paymentMethod,
			String description, String externalReference, double amount, String url, LocalDate accreditationDate,
			LocalDate dueDate, LocalDate secondDueDate, LocalDateTime paymentDate, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.spId = spId;
		this.barcode = barcode;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.externalReference = externalReference;
		this.amount = amount;
		this.url = url;
		this.accreditationDate = accreditationDate;
		this.dueDate = dueDate;
		this.secondDueDate = secondDueDate;
		this.paymentDate = paymentDate;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public ProofPayment() {
		super();
	}
	
    
}
