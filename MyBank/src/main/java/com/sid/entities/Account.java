package com.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//single table mean one table for all class(current account and savingsaccount). This is not efficient, when there is too many zero
//in the table
//if the case, there will be a new created colomn, to represent the type of the account.
//the default type is varchar and the default length is 255, but one can specify it with the DiscriminatorType attribute
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACC_TYPE", discriminatorType = DiscriminatorType.STRING, length=2)
public abstract class Account implements Serializable{
	@Id 
	@Column(length=40)
	private String accountCode;
	private Date dateCreation;
	private double balance;
	
	//When the ManyToOne cardinality is call here, the will be a foreign key created to materialize the fact that a client is the owner
	//of this account. The the default name of this foreign key is client, but ont can change it with the annotation @Joincolumn by
	//giving the name to the attribute name.
	@ManyToOne
	@JoinColumn(name ="CLI_CODE")
	private Client client;
	
	//account represent the attribute in the class(Entity) Operation mapped by the operations of this collection
	@OneToMany(mappedBy = "account")
	private Collection<Operation> operations;
	
	public Account() {
		super();
	}

	public Account(String accountCode, Date dateCreation, double balance, Client client) {
		super();
		this.accountCode =accountCode;
		this.dateCreation = dateCreation;
		this.balance = balance;
		this.client = client;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}



}
