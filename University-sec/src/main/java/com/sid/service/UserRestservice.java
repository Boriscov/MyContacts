package com.sid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.RoleRepository;
import com.sid.dao.UserRepository;
import com.sid.entities.Role;
import com.sid.entities.User;

@RestController
@Secured(value = {"ROLE_ADMIN"})
public class UserRestservice {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
	@RequestMapping(value="/addUser")
	public User saveUser(User u) {
		return userRepository.save(u);
	}
	
	@RequestMapping(value="/findUsers")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role saveRole(Role r) {
		return roleRepository.save(r);
	}
	
	@RequestMapping(value = "/findRoles")
	public List<Role> findRoles(){
		return roleRepository.findAll();
	}
	
	@RequestMapping(value = "/addRoleToUser")
	public User addRoleToUser(String username, String role) {
		
		User u = userRepository.getOne(username);
		Role r = roleRepository.getOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
		
	}

}
