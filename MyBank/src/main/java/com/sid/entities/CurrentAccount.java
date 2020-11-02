package com.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{
	
	//An overdraft(le decouvert ou authorisation de decouvert) occurs when money is withdrawn( est retire) from a bank account and the available balance goes below zero
	private double overdraft;

	public CurrentAccount() {
		super();
	}


	public CurrentAccount(String accountCode, Date dateCreation, double balance, Client client, double overdraft) {
		super(accountCode, dateCreation, balance, client);
		this.overdraft = overdraft;
	}


	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	

}
