package com.global.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.global.model.Employee;
import com.global.serves.EmployeeServes;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private EmployeeServes employeeServes;



@GetMapping("count")
	public Long count() {
		
		return employeeServes.count();
	}
	

@GetMapping("/{id}")
public Employee findByID(@PathVariable Long id) {
	return employeeServes.findByID(id);
}

	
 //@GetMapping("/")
@RequestMapping(method = RequestMethod.GET,value = "/")
public List<Employee> find() {
	
	return (List<Employee>) employeeServes.find();
}
	
	
@PostMapping("/insert")
public Employee insert(@RequestBody Employee em) {
	return employeeServes.insert(em);
}

@PutMapping("/")
public Employee UPdate(@RequestBody Employee em) {
	return employeeServes.Update(em);
}

@GetMapping("/filterN/{name}")
public List<Employee> FilterByName(@PathVariable String name) {
	return employeeServes.findByName(name);
}


@GetMapping("/filterNS")
public List<Employee> FilterByName_Salary(@RequestParam String name,@RequestParam Double salary) {
	return employeeServes.findByNameAndSalary(name, salary);
}

@DeleteMapping("/{emp_id}")
public void deletEmp(@PathVariable(name ="emp_id" ) Long id) {
	employeeServes.delete(id);
}

@PutMapping("/salary")
public int updateSalary(@RequestParam Double salary ,@RequestParam Long id) {
	return employeeServes.updateSalary(salary, id);
}


}
