package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.hr.entity.Department;
import com.global.hr.reposetory.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	public Department findById (Long id) {
		 return departmentRepo.findById(id).orElseThrow();
		}
	

	public Department insert(Department emp) {
		return departmentRepo.save(emp);
	}
	public Department update(Department emp) {
		Department current = departmentRepo.findById(emp.getId()).orElseThrow();
		current.setName(emp.getName());  

		return departmentRepo.save(current);
	}

public  List<Department> find_all() {
		
		return departmentRepo.findAll();
	}
	
}