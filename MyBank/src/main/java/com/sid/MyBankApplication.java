package com.sid;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

import com.sid.business.IBankBusiness;
import com.sid.dao.AccountRepository;
import com.sid.dao.ClientRepository;
import com.sid.dao.OperationRepository;
import com.sid.entities.Account;
import com.sid.entities.Client;
import com.sid.entities.CurrentAccount;
import com.sid.entities.Payment;
import com.sid.entities.SavingsAccount;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBankBusiness bankBusiness;
	
	public static void main(String[] args) {
		
		SpringApplication.run(MyBankApplication.class, args);
		//ApplicationContext ctx= SpringApplication.run(MyBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Client c1 = clientRepository.save(new Client("Ndouemabieu", "ndouemabieu@gmail.com"));
		Client c2 = clientRepository.save(new Client("Kamdem", "Kamdem@gmail.com"));
		
		Account a1 = accountRepository.save( new CurrentAccount("a1", new Date(), 9000, c1, 6000));
		Account a2 = accountRepository.save( new SavingsAccount("a2", new Date(), 3000, c2, 5.5));
		
		operationRepository.save(new Payment(new Date(), 10000, a1));
		operationRepository.save(new Payment(new Date(), 10000, a2));
		
		bankBusiness.deposit("a1", 111111);
		bankBusiness.deposit("a2", 222222);
		
	}

}
