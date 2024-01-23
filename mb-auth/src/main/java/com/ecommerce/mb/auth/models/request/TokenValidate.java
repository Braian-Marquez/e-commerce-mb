package com.ecommerce.mb.auth.models.request;

public class TokenValidate {
	private String role;
	private Long idProfile;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
	}
	
}
