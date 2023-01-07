package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.model.Employee;
import com.global.reposetry.EmployeeRepos;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeRepoImplment")
	private EmployeeRepos employeeRepos_interface; 
	
	
	
	@GetMapping("/count")
	public int countEmps() {
		return employeeRepos_interface.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
	
		return employeeRepos_interface.findById(id);
	}
	
	@GetMapping("")
	public List<Employee> findAll() {
	
		return employeeRepos_interface.findAll();
	}
	
	
	
	
	
	
	
	
}
