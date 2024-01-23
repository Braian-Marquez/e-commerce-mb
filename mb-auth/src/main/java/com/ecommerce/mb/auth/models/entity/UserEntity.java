package com.ecommerce.mb.auth.models.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@SQLDelete(sql = "UPDATE usuario SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Table(name = "usuario", indexes = @Index(name = "unique_email", columnList = "email", unique = true))
public class UserEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	@SuppressWarnings("unused")
	private String username;

	private String password;

	private Boolean validation = false;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<RoleEntity> roles;

	@CreationTimestamp
	@Column(name = "create_timestamp")
	private Timestamp createTimestamp;

	@Column(name = "soft_delete")
	private Boolean softDelete = Boolean.FALSE;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles().stream().map((RoleEntity role) -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	public String getUsername() {
		return email;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return !this.softDelete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Boolean getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(Boolean softDelete) {
		this.softDelete = softDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserEntity(Long id, String email, String username, String password, Boolean validation,
			List<RoleEntity> roles, Timestamp createTimestamp, Boolean softDelete) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.validation = validation;
		this.roles = roles;
		this.createTimestamp = createTimestamp;
		this.softDelete = softDelete;
	}

	public UserEntity() {
		super();
	}

}
