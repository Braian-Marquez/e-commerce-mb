package com.ecommerce.mb.commons.models.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql = "UPDATE product SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long commerceId;
	private String name;
	private String description;
	private double price;
	@OneToMany
	private List<ImageEntity> image;
	@OneToOne
	private Category category;
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public List<ImageEntity> getImage() {
		return image;
	}

	public void setImage(List<ImageEntity> image) {
		this.image = image;
	}

	
	public Long getCommerceId() {
		return commerceId;
	}

	public void setCommerceId(Long commerceId) {
		this.commerceId = commerceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Product(Long id, Long commerceId, String name, String description, double price, List<ImageEntity> image,
			Category category, Boolean softDelete, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.commerceId = commerceId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
		this.softDelete = softDelete;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Product() {
		super();
	}

}
