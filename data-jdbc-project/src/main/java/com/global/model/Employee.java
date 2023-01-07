package com.global.model;



import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public class Employee {

	@Id
	@Column("id")
	private Long employeeId;
	private String name;
	private Double salary;
	 
	@Transient        // it mean you need this variable only in this class not in DB
	private Boolean isCreated;
	
//**************************************	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
public Employee(Long employeeId, String name, Double salary) {
	super();
	this.employeeId = employeeId;
	this.name = name;
	this.salary = salary;
}
//**************************************	

public Long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public Boolean getIsCreated() {
	return isCreated;
}
public void setIsCreated(Boolean isCreated) {
	this.isCreated = isCreated;
}
	
	
	
	
	
}
