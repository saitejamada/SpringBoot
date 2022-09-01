package com.emp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Credientials {

	@Id
	@NotNull
	@Size(min = 5,message="Should Be Atleast 6 characters")
	String username;
	String password;
	String role;
	@OneToOne(fetch = FetchType.LAZY)
	Employee e;
	
	public Employee getE() {
		return e;
	}
	public void setE(Employee e) {
		this.e = e;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Credientials [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
