package com.sid.service;

import com.sid.entities.AppRole;
import com.sid.entities.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String userName, String roleName);
	public AppUser findUserByUserName(String username);

}
