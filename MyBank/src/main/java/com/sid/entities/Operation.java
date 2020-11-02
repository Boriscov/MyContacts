package com.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//single table mean one table for all class(current account and savingsaccount). This is not efficient, when there is too many zero
//in the table. If the case, there will be a new created colomn, to represent the type of the operation.
//the default type is varchar and the default length is 255, but one can specify it with the DiscriminatorType attribute
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OP_TYPE", discriminatorType = DiscriminatorType.STRING, length=1)
public abstract class Operation implements Serializable{
	@Id @GeneratedValue
	private Long number;
	private Date dateOperation;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="ACC_CODE")
	private Account account;
	
	
	public Operation() {
		super();
	}


	public Operation(Date dateOperation, double amount, Account account) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
		this.account = account;
	}


	public Long getNumber() {
		return number;
	}


	public void setNumber(Long number) {
		this.number = number;
	}


	public Date getDateOperation() {
		return dateOperation;
	}


	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	
}
