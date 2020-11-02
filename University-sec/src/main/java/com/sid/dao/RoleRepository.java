package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
