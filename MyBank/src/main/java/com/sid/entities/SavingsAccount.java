package com.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//taux d´interet
	private double rate;

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(String accountCode, Date dateCreation, double balance, Client client, double rate) {
		super(accountCode, dateCreation, balance, client);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
