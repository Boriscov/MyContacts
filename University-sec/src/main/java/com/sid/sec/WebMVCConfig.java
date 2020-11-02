package com.sid.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// to configure an api web mvc server side (controller), one need to inherite from the class WebMvcConfigurerAdapter
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		//super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");
	
	}

}
