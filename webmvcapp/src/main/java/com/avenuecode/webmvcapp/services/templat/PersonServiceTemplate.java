package com.avenuecode.webmvcapp.services.templat;

import com.avenuecode.webmvcapp.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonServiceTemplate {
	
	public void create(Person person);
	public void update(Person person);
	public void deleteByID(String id);
	public void deleteAll();
	public Person findById(String id);
	public List<Person> findAll();
	
	
}



