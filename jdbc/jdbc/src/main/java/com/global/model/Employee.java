package com.global.model;




public class Employee {

	private Long Id;
	private String name;
	private Double salary;
//**************************************	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
public Employee(Long id, String name, Double salary) {
	super();
	this.Id = id;
	this.name = name;
	this.salary = salary;
}
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
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
	
	
	
	
	
}
