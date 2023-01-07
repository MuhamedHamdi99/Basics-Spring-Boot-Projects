package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Employee;
import com.global.hr.entity.EmployeeReponse;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/empp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
public EmployeeReponse findById(@PathVariable Long id) {
		
		Employee emp = employeeService.findByID(id);
		
		EmployeeReponse res= new EmployeeReponse ();
		res.setId(emp.getId());
		res.setName(emp.getName());
		res.setDepartment(emp.getDepartment());
		res.setUser(emp.getUser());
		

		return res;
	}
	

	@PostMapping()
	public Long insert(Employee emp) {
		Employee ins = employeeService.insert(emp);
		return ins.getId();
		
	}
	@PutMapping()
	public Employee update(@RequestBody Employee emp) {

		return employeeService.update(emp);
	}

@GetMapping("/deps/{id}")
public  List<Employee> findByDepartmentId(@PathVariable Long id) {
		
		return employeeService.findByDepartmentId(id);
	}
	
@GetMapping("/")	
public  List<Employee> find_all() {
		
		return employeeService.find_all();
	}

@GetMapping("/getEmp-Dept")
public List<Employee> findByEmpAndDept(@RequestParam String empName,@RequestParam String deptName){
	
	return employeeService.findByEmpAndDept(empName, deptName);
}

@DeleteMapping("/EmpDep")
public Long DeleteEmpAndDept(@RequestParam String empName,@RequestParam String deptName){
	
	return employeeService.Delete_EmpAndDept(empName, deptName);
}


@GetMapping("/getSalary")
public List<Employee> findBysalary(@RequestParam Double salary){
	
	return employeeService.findBysalary(salary);
}

@GetMapping("/Projection")
public HRStatisticProjection getHRStatistic () {
	return employeeService.getHRStatistic();
}


	
}