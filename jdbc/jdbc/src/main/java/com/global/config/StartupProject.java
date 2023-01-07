package com.global.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.model.Employee;
import com.global.reposetry.EmployeeRepos;

@Component
public class StartupProject implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	@Qualifier("employeeRepoImplment")
	private EmployeeRepos employeeRepos;
	
	
	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("DROP TABLE IF EXISTS employees");
		jdbcTemplate.execute("CREATE TABLE employees(id SERIAL, name VARCHAR(255), salary NUMERIC(15, 2))");
		
		if(employeeRepos.count() == 0) {
			employeeRepos.insert(new Employee(20L, "Mohamed", 5221.0));
			employeeRepos.insert(new Employee(30L, "Nour", 8569.0));
			employeeRepos.insert(new Employee(40L, "Ali", 5521.0));
			
		}
		
		
		
	}

}