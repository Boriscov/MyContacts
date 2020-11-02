package com.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	//I  need all operation from an account and I want to check it page after page
	//in spring one need to declare on object pageable, when one need to return a page
	//
	@Query("select o from Operation o where o.account.accountCode=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param("x")String acCode, Pageable pageable);

}
