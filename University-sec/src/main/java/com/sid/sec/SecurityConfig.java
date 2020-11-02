package com.sid.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// annotation to protect methods is @EnableGlobalMethodSecurity
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		// for static user DB use inmemoryauthentication
		/*
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof1").password("{noop}123").roles("PROF");
		auth.inMemoryAuthentication().withUser("std1").password("{noop}123").roles("STUDENT");
		auth.inMemoryAuthentication().withUser("bei1").password("{noop}123").roles("BEITRAG");
		*/
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, true from users where = username = ?")
		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from users_roles where user_username = ?")
		.rolePrefix("ROLE_");
		
		
	}
	
	//Method to protect our ressource
	// one can also to tabulation to program this part. se youssfi 43:30 for this video
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// disable the default jwt hidden in the html code of the navigator
		http.csrf().disable();
		// this means all request most be authenticated. That means also, that the authentication formular is not accessible.
		http.authorizeRequests().anyRequest().authenticated();
		//if the authentication page is static, put login.html, but if it is a formular generated from the server side, put /login. To give access autorisation use permitAll()
		http.formLogin().loginPage("/login").permitAll();
		//default page;
		http.formLogin().defaultSuccessUrl("/index.html");
		//defauld page for access denied

		/*http.antMatcher("/css/**");
		http.antMatcher("/js/**");
		http.antMatcher("/images/**");*/
	}

}
