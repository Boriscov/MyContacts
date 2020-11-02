package com.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//Versement
@Entity
@DiscriminatorValue("P")
public class Payment extends Operation{

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Date dateOperation, double amount, Account account) {
		super(dateOperation, amount, account);
		// TODO Auto-generated constructor stub
	}

}
