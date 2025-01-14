package com.sid.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Since it is a configuration class
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*The first methode (only for test) consist of defining some on memory users.
		   auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}1234").roles("ADMIN","USER")
			.and()
			.withUser("user").password("{noop}1234").roles("USER");
			
			
			//Annother method is JDBC authentication:
			//auth.jdbcAuthentication()
			//.usersByUsernameQuery("sql request to be executed by Spring to get username and password")
			//.authoritiesByUsernameQuery("sql request to get roles")
			//after add the encoding typ, etc
		*/
		// The second method:
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	//Methode to define access right, filter if needed
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//don't create session (quand on veut passer a un systeme d authe. de ref a un par valeur)
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//Authentication formular
		//http.formLogin();
		//ahtorise all /login and /register request
		http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
		//if a request is send with post/tasks by an Admin, it is ok
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/tasks/**").hasAuthority("ADMIN");
		//All request most be autheticated
		http.authorizeRequests().anyRequest().authenticated();
		//http.authorizeRequests().anyRequest().permitAll();
		
		//to use the Token of class JWTSpring...
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
