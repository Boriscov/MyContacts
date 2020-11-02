package com.sid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sid.dao.TaskRepository;
import com.sid.dao.UserRepository;
import com.sid.entities.AppRole;
import com.sid.entities.AppUser;
import com.sid.entities.Task;
import com.sid.service.AccountService;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner{
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		Collection<AppRole> roles = new ArrayList<>();
		roles.add(new AppRole(null, "ADMIN"));
		roles.add(new AppRole(null, "USER"));
		
		Collection<AppRole> roles2 = new ArrayList<>();
		roles2.add(new AppRole(null, "USER"));
		
		accountService.saveUser(new AppUser(null, "admin", "1234", null ));
		accountService.saveUser(new AppUser(null, "user", "1234", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));
		System.out.println("aaaaaaaaaa");
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		//userRepository.save(new AppUser(null, "admin", "123", null ));
		//userRepository.save(new AppUser(null, "user", "123", null ));
		
		/*AppUser u1 = new AppUser();
		u1.setUsername("molla");
		u1.setPassword("1234");*/
		
		
		//AppUser ac = accountService.findUserByUserName("molla");
		//System.out.println(ac.getUsername());
		
		
		Stream.of("T1", "T2", "T3").forEach(t->{
			taskRepository.save(new Task(null, t));
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}

}
