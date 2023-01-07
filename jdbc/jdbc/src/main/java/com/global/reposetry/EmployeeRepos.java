package com.global.reposetry;

import java.util.List;

import com.global.model.Employee;

public interface EmployeeRepos {

	
	int count();

	Employee findById(Long id);

	List<Employee> findAll();
	
	int insert(Employee employee);

	int update(Employee employee);
	
	int delete (Long id);

	Employee findByIdName_and_salary(String name, Double salary);
	
}
