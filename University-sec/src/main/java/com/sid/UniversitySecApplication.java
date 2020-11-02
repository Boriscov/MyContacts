package com.sid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sid.dao.StudentRepository;
import com.sid.entities.Student;

@SpringBootApplication
public class UniversitySecApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(UniversitySecApplication.class, args);
	//SpringApplication.run(UniversitySecApplication.class, args);
		StudentRepository sr = ctx.getBean(StudentRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		sr.save(new Student("Kamdem", "boris", df.parse("03.12.2000") ));
		sr.save(new Student("Kamdem2", "boris2", df.parse("03.12.2000") ));
		sr.save(new Student("Kamdem3", "boris3", df.parse("03.12.2000") ));
		sr.save(new Student("Kamdem4", "boris4", df.parse("03.12.2000") ));
		sr.save(new Student("Kamdem5", "boris5", df.parse("03.12.2000") ));
		sr.save(new Student("Kamdem6", "boris6", df.parse("03.12.2000") ));
		
		List<Student> st = sr.findAll();
		
		// java 8
		st.forEach(e -> System.out.println(e.getLastName()));
		
		/*for(Student e: st) {
			System.out.println(e.getLastName());
		}*/
	}

}
