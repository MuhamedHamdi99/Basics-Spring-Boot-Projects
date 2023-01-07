package com.global.hr.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "sec_users")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String password;

	@OneToOne(mappedBy = "user")
	private Employee emp;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sec_user_roles"
	           , joinColumns = @JoinColumn(name= "user_id")
	           , inverseJoinColumns = @JoinColumn (name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
	
}
