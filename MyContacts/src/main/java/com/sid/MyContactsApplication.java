package com.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.dao.ContactRepository;
import com.sid.entities.Contact;

@SpringBootApplication
public class MyContactsApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		/*contactRepository.save(new Contact("Kamdem", "boris", df.parse("03.12.2000"), "boriskamdem@canass.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("sixkiller", "bobby", df.parse("03.12.2000"), "bobbysixkiller@canass.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("eyamo", "ela", df.parse("03.12.2000"), "eyamoela@ebolowa.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("murielle", "deloushka", df.parse("03.12.2000"), "murielledeloushka@ebolowa.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("brad", "raphael", df.parse("03.12.2000"), "bradraphael@douala.cmr", "00237697269", "borisimg.jpg" ));
		
		contactRepository.save(new Contact("Kamdem2", "boris", df.parse("03.12.2000"), "boriskamdem@canass2.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("sixkiller2", "bobby", df.parse("03.12.2000"), "bobbysixkiller@canass2.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("eyamo2", "ela", df.parse("03.12.2000"), "eyamoela@ebolowa2.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("murielle2", "deloushka", df.parse("03.12.2000"), "murielledeloushka@ebolowa2.cmr", "00237697269", "borisimg.jpg" ));
		contactRepository.save(new Contact("brad2", "raphael", df.parse("03.12.2000"), "bradraphael@douala2.cmr", "00237697269", "borisimg.jpg" ));
		*/
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getLastName());
		});
		
	}

}
