package com.sid.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sid.dao.RoleRepository;
import com.sid.dao.UserRepository;
import com.sid.entities.AppRole;
import com.sid.entities.AppUser;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		//user.setUsername(hashPW);
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	public AppRole saveRole(AppRole role) {	
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = new AppUser();
		user = userRepository.findByUsername(username);
		//AppUser user2 = new AppUser();
		user.getRoles().add(role);	
	}

	@Override
	public AppUser findUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
