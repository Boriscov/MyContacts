package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Client;

//One use Springdata to manage entity. One has to create jpa interface
//one can also use jpa by using entity manager
public interface ClientRepository extends JpaRepository<Client, Long> {

}
