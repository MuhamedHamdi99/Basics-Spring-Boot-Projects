package com.global.reposetry;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.global.mapper.EmployeeMapper;
import com.global.model.Employee;


@Component
@Qualifier("employeeNamedParameterRepoImplment")
public class EmployeeNamedParameterRepoImplment implements EmployeeRepos{

	@Autowired  // field injection by constructor
	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee findById(Long id) {
		return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employees where id :id",
				new MapSqlParameterSource("id",id),new EmployeeMapper());
				
	}
	
	@Override
	public Employee findByIdName_and_salary(String name , Double salary) {
		
		MapSqlParameterSource mapParam = new MapSqlParameterSource();
		mapParam.addValue("name", name);
		mapParam.addValue("salary", salary);
		
		return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employees where name =:name and salary =:salary",
				mapParam,new EmployeeMapper());
				
	}
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Employee employee) {
		
		return namedParameterJdbcTemplate.update("insert into employees (id, name, salary) values (:id, :name, :salary)",
				new  BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int update(Employee employee) {
		return namedParameterJdbcTemplate.update("update employees set name= :name , salary :salary",
				new  BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
