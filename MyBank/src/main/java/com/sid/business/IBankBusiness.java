package com.sid.business;

import org.springframework.data.domain.Page;

import com.sid.entities.Account;
import com.sid.entities.Operation;

public interface IBankBusiness {
	
	public Account checkAccount(String acCode);
	public void deposit(String acCode, double amount);
	public void withdraw(String acCode, double amount);
	public void transfer(String acCode1, String acCode2, double amount);
	public Page<Operation> listOperation(String acCode, int page, int size);

}
