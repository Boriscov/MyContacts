package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName(String roleName);
	;
	
	
	
}
