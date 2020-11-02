package com.sid.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sid.entities.AppUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private AccountService accountService;

	//Puisque c est une methode de Spring qui est implementee ici, if faut donc ajouter les roles
	//d un user defini par notre app aux roles du meme user defini par le framework Spring avant
	//de le retourner. Le username et le mot de passe sont deja definis
	//return an object of Typ User (user of spring). This user implement userDetails
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = accountService.findUserByUserName(username);
		//System.out.println("ccccccc");
		System.out.println(username);
		//System.out.println(user.getPassword());
		if(user==null) throw new UsernameNotFoundException(username);
		//System.out.println("ccccccc");
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		//for each role of our appUser, add them in the role list of Spring for this user (authorities)
		user.getRoles().forEach( r-> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
			});
		
		return new User(user.getUsername(), user.getPassword(), authorities);
		}
		
}
