package com.sid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sid.business.IBankBusiness;

/*
 * @Controller annotation is an annotation used in Spring MVC framework (the component of Spring Framework used to implement Web Application). 
 * The @Controller annotation indicates that a particular class serves the role of a controller. The @Controller annotation acts as a stereotype for the annotated class, 
 * indicating its role. The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.
 * So looking at the Spring MVC architecture you have a DispatcherServlet class (that you declare in your XML configuration) that represent
 * a front controller that dispatch all the HTTP Request towards the appropriate controller classes (annotated by @Controller). 
 * This class perform the business logic (and can call the services) by its method. These classes (or its methods) are typically annotated also
 *  with @RequestMapping annotation that specify what HTTP Request is handled by the controller and by its method.
 *  This is simply a specialization of the @Component class and allows implementation classes to be autodetected through the classpath scanning.
*/
@Controller
public class BankController {
	@Autowired
	private IBankBusiness bankBusiness;
	
	//Simple method to return a view as default, to access to this, one need the annotation @Requestmapping
	@RequestMapping("/operation")
	public String index() {
		return "accounts";
	}

}
