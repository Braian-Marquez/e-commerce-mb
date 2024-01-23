package com.ecommerce.mb.commons.models.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name="details_order")
public class DetailsOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer quantity;
	private Long idProduct;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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

	public DetailsOrder(Long id, String name, Integer quantity, Long idProduct, Boolean softDelete,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.softDelete = softDelete;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public DetailsOrder() {
		super();
	}

}
