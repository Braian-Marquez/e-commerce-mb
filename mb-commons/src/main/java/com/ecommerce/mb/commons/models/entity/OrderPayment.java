package com.ecommerce.mb.commons.models.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "order_payment")
public class OrderPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String datail;
	private Double price;
	private Integer idSp;
	private String referenceId;
	private String paymentMethod;
	private String status;
	
	@OneToOne
	private ProofPayment proof;
	
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

	public String getDatail() {
		return datail;
	}

	public void setDatail(String datail) {
		this.datail = datail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIdSp() {
		return idSp;
	}

	public void setIdSp(Integer idSp) {
		this.idSp = idSp;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProofPayment getProof() {
		return proof;
	}

	public void setProof(ProofPayment proof) {
		this.proof = proof;
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

	public OrderPayment(Long id, String datail, Double price, Integer idSp, String referenceId, String paymentMethod,
			String status, ProofPayment proof, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.datail = datail;
		this.price = price;
		this.idSp = idSp;
		this.referenceId = referenceId;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.proof = proof;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public OrderPayment() {
		super();
	}
	
}
