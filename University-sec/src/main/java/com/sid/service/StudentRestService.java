package com.sid.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.StudentRepository;
import com.sid.entities.Student;

// Mvc from the client side need the annotation @RestController and mvc from server side need @Controller
@RestController
public class StudentRestService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	// Annotation to get the method via the http (url)
	@Secured(value= {"ROLE_ADMIN", "ROLE_BEITRAG"})
	@RequestMapping(value="/saveStudent", method=RequestMethod.GET)
	public Student saveStudent(Student s) {
		return studentRepository.save(s);
	}
	
	@Secured(value= {"ROLE_ADMIN", "ROLE_BEITRAG", "ROLE_PROF", "ROLE_STUDENT"})
	@RequestMapping(value="/students")
	public Page<Student> listStudents(int page, int size){
		return studentRepository.findAll(PageRequest.of(page, size));
	}
	
	@RequestMapping(value="/students2", method=RequestMethod.GET)
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	@Secured(value= {"ROLE_ADMIN", "ROLE_BEITRAG", "ROLE_PROF", "ROLE_STUDENT"})
	@RequestMapping(value="/getLoggedUser")
	public Map<String, Object> getLoggedUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		//get the name of the authenticated user
		String username = securityContext.getAuthentication().getName();
		
		//get the roles of the authenticated user. Spring save them with type Grantedauthority
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		
		Map<String, Object> params=new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		
		return params;
	}

}
