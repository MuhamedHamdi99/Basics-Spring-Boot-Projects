package com.global.serves;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.model.*;
import com.global.reposetry.*;

@Service
public class EmployeeServes {

	@Autowired
	private EmployeeRepos employeeRepos;

	
public Long count() {
		
		return employeeRepos.count();
	}

public Employee findByID( Long id) {
	return employeeRepos.findById(id).get();
}
	

public Employee insert( Employee em) {
	return employeeRepos.save(em);
}

 
public Employee Update(  Employee em) {
	return employeeRepos.save(em);
}


public void delete( Long id) {
	employeeRepos.deleteById(id);
}

public List<Employee> find() {
	
	return (List<Employee>) employeeRepos.findAll();
}
	

	public List<Employee> findByNameAndSalary( String name,Double empSalary){
		return employeeRepos.findByNameAndSalary(name, empSalary);
	}
	
	public List<Employee> findByName(String name){
		return employeeRepos.findByName(name);
	}

	public int updateSalary(Double salary , Long id) {
		return employeeRepos.updateSalary(salary, id);
	}


}
