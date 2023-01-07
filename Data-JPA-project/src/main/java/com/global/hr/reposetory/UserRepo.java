package com.global.hr.reposetory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.global.hr.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	
}
