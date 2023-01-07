package com.global.hr.reposetory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Employee;

import jakarta.transaction.Transactional;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	List<Employee> findByDepartmentId(Long id);
	
	List<Employee> findBysalary(Double salary);
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameContainingAndDepartmentNameContaining(String empName, String deptName);
	
	@Modifying
	@Transactional
	Long deleteByNameContainingAndDepartmentNameContaining(String empName, String deptName);	
	
	
	// this is the JPQL 
		@Query(value = "select emp from Employee emp where emp.name =: empName")
		Page<Employee> filter(@Param("empName") String name);
		
		
		
		// this is the sql native 
		@Query(value = "select * from HR_Employee emp where emp.emp_name like :empName", nativeQuery = true)
		List<Employee> filterNative(@Param("empName") String name);
	
		
		
		
		@Query(value = "select (select count(*) from hr_departments) deptCount,"
				+ " (select count(*) from hr_employees) empCount,"
				+ " (select count(*) from sec_users ) userCount"
				, nativeQuery = true)
		HRStatisticProjection getHRStatistic ();
		
}
