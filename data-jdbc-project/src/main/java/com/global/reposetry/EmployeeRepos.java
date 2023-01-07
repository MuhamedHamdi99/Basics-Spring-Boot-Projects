package com.global.reposetry;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.model.Employee;


@Repository
public interface EmployeeRepos  extends CrudRepository<Employee, Long>{

	@Query(value = "SELECT * FROM employees WHERE name like :empName AND salary >= :empSalary")
	List<Employee> findByNameAndSalary(@Param("empName") String name,Double empSalary);
	
	List<Employee> findByName(String name);
	//List<Employee> findByNameAndSalary(String name,Double salary);
	
	@Modifying
	@Query(value = "UPDATE employees SET salary =:salary WHERE id =:id")
	int updateSalary(Double salary , Long id);
	
	
}
