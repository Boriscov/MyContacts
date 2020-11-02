package com.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//Retrait
@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Operation{

	public Withdrawal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Withdrawal(Date dateOperation, double amount, Account account) {
		super(dateOperation, amount, account);
		// TODO Auto-generated constructor stub
	}
	
	

}
