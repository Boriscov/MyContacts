package com.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
public class Contact implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;
	
	//Annotation to format this type in the database. TemporalType.DATE means one just save the date.
	// @Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "email", length = 50, unique = true)
	private String email;
	//if one declare it with type int or long, the first 0 will not be saved in the database
	private String tel;
	private String image;
	
	public Contact() {
		super();
	}

	public Contact(String lastName, String firstName, Date dateOfBirth, String email, String tel, String image) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.tel = tel;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
