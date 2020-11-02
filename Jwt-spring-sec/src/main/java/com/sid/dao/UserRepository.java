package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sid.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	//public AppUser findByUserName(String userName);
	public AppUser findByUsername(String username);
	

}
