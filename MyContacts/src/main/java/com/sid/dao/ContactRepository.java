package com.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.entities.Contact;

//spring data make easier the ORM
public interface ContactRepository extends JpaRepository<Contact, Long>{
	//method to search contact
	@Query("select c from Contact c where c.lastName like :x")
	public Page<Contact> search(@Param("x") String k, Pageable pageable);

}
