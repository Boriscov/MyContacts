package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.entities.Task;

//Annotation issue de SpringDataRest pour les API Rest
//@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long>{
	

}
