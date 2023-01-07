package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;
import com.global.hr.reposetory.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DepartmentService departmentService;
	
	

//************************************************************************	
	public Employee findByID(Long id) {
		return employeeRepo.findById(id).orElseThrow();
	}
	
//************************************************************************	
	public Employee insert(Employee emp) {
if (emp.getDepartment() != null && emp.getDepartment().getId() != null) {
			
			Department dept = departmentService.findById(emp.getDepartment().getId());
			dept.setName(emp.getDepartment().getName());
			
			emp.setDepartment(dept);
			}
		
		
		
		return employeeRepo.save(emp);
	}

//************************************************************************	
	
	
	
	public Employee update(Employee emp) {
		Employee current = employeeRepo.findById(emp.getId()).orElseThrow();
		current.setName(emp.getName());
		current.setSalary(emp.getSalary());
		current.setDepartment(emp.getDepartment());

		return employeeRepo.save(current);
	}
//************************************************************************	
	
	
	public  List<Employee> findByDepartmentId(Long id) {
		
		return employeeRepo.findByDepartmentId(id);
	}	
//************************************************************************	
	
public  List<Employee> find_all() {
		
		return employeeRepo.findAll();
	}
//************************************************************************
public List<Employee> findByEmpAndDept(String empName, String deptName){
	
	return employeeRepo.findByNameContainingAndDepartmentNameContaining(empName, deptName);
}

public Long Delete_EmpAndDept(String empName, String deptName){
	
	return employeeRepo.deleteByNameContainingAndDepartmentNameContaining(empName, deptName);
}

public List<Employee> findBysalary(Double salary){
	
	return employeeRepo.findBysalary(salary);
}

public HRStatisticProjection getHRStatistic () {
	return employeeRepo.getHRStatistic();
}








}
