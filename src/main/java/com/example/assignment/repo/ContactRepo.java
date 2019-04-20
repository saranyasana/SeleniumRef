package com.example.assignment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.assignment.model.Contacts;



public interface ContactRepo extends MongoRepository<Contacts, String>{
	
	 public Optional<Contacts> findByName(String name); 

	
	
	@Query("{'Device.name': ?0}")
	public  Contacts findByDevice(String name);

	
}
