package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.global.hr.entity.Department;
import com.global.hr.service.DepartmentService;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/{id}")
	public Department findByID(@PathVariable Long id) {
		return departmentService.findById(id);
	}
	
	@PostMapping()
	public Department insert(@RequestBody Department emp) {
		return departmentService.insert(emp);
	}
	@PutMapping()
	public Department update(@RequestBody Department emp) {

		return departmentService.update(emp);
	}
	
@GetMapping("/")	
public  List<Department> find_all() {
		
		return departmentService.find_all();
	}
	
}
