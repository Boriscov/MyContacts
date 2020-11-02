package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
