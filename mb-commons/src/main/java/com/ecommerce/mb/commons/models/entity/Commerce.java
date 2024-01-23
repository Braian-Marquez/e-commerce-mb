package com.ecommerce.mb.commons.models.entity;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@SQLDelete(sql = "UPDATE commerce SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Table(name = "commerce")
public class Commerce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String buisnessName;
	@OneToOne
	private Address adress;
	private String numberPhone;
	private String cuit;
	private String fantasyName;
	private Long idUser;
	@OneToMany()
	private List<Product> categories;

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

	public String getBuisnessName() {
		return buisnessName;
	}

	public void setBuisnessName(String buisnessName) {
		this.buisnessName = buisnessName;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}


	public List<Product> getCategories() {
		return categories;
	}

	public void setCategories(List<Product> categories) {
		this.categories = categories;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public Commerce(Long id, String buisnessName, Address adress, String numberPhone, String cuit, String fantasyName,
			Long idUser, List<Product> categories, Boolean softDelete, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.buisnessName = buisnessName;
		this.adress = adress;
		this.numberPhone = numberPhone;
		this.cuit = cuit;
		this.fantasyName = fantasyName;
		this.idUser = idUser;
		this.categories = categories;
		this.softDelete = softDelete;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Commerce() {
		super();
	}

}
