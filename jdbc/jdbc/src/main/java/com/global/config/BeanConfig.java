package com.global.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.global.reposetry.EmployeeRepoImplment;

@Configuration
public class BeanConfig {
	
	@Bean()
	@Scope("singleton")
	@Qualifier("getEmployeeRepoImplment")
	public EmployeeRepoImplment getEmployeeJDBCRepo() {
		
		return new EmployeeRepoImplment();
	}

}