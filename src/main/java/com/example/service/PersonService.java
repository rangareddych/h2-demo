package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Person save(Person person) {
		return repository.save(person);
	}
	
	public void delete(Person person) {
		repository.delete(person);
	}
}
