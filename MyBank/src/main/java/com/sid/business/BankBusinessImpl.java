package com.sid.business;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.dao.AccountRepository;
import com.sid.dao.OperationRepository;
import com.sid.entities.Account;
import com.sid.entities.CurrentAccount;
import com.sid.entities.Operation;
import com.sid.entities.Payment;
import com.sid.entities.Withdrawal;

//the annotation @service is here for the instanciation of this class by the start of the App
//It is generaly use for object of the business layer
//If one need that spring manage transaction or need to delegate the transaction to spring, one need to use the annotation @transaction
@Service
@Transactional
public class BankBusinessImpl implements IBankBusiness{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	
	public Account checkAccount(String acCode) {

		Optional<Account> acc = accountRepository.findById(acCode);
		boolean b = acc.isPresent();
		if(b == true) {
			Account ac = acc.get();
			return ac;
		}
		else {
			throw new RuntimeException("Account unfindable");
		}
		
	}


	public void deposit(String acCode, double amount) {
		
		Account acc = checkAccount(acCode);
		Payment p = new Payment(new Date(), amount, acc);
		operationRepository.save(p);
		acc.setBalance(acc.getBalance() + amount);
		accountRepository.save(acc);
	}


	public void withdraw(String acCode, double amount) {
		
		Account acc = checkAccount(acCode);
		double facilityBox=0;
		if(acc instanceof CurrentAccount)
			facilityBox = ((CurrentAccount) acc).getOverdraft();
		if(acc.getBalance() + facilityBox < amount)
			throw new RuntimeException("Balance unsufficient");
		Withdrawal w = new Withdrawal(new Date(), amount, acc);
		operationRepository.save(w);
		acc.setBalance(acc.getBalance() - amount);
		accountRepository.save(acc);
		
	}


	public void transfer(String acCode1, String acCode2, double amount) {
		withdraw(acCode1, amount);
		deposit(acCode2, amount);		
	}
	

	//get the list of operations of accounts page after page (page/account operations)
	@Override
	public Page<Operation> listOperation(String acCode, int page, int size) {
		//return operationRepository.listOperation(acCode, new PageRequest(page, size, Sort.unsorted()));
		return operationRepository.listOperation(acCode, PageRequest.of(page, size));
		//return null;
	}

}
