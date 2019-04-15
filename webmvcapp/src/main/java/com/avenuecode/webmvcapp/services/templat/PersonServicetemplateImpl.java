package com.avenuecode.webmvcapp.services.templat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.avenuecode.webmvcapp.domain.Person;
//import com.avenuecode.webmvcapp.repositories.PersonRepository;


@Repository
@Service
public class PersonServicetemplateImpl implements PersonServiceTemplate {
	
	
	@Autowired
    MongoTemplate mongoTemplate;
	

	@Override
	public void create(Person person) {
		mongoTemplate.insert(person);
		
	}
	
	
	@Override
	public void update(Person person) {
		mongoTemplate.save(person);
		
		
	}

	@Override
	public void deleteByID(String id) {
		mongoTemplate.remove(id);
		
	}

	@Override
	public void deleteAll() {
		//mongoTemplate.remove(id);
		
	}

	@Override
	public Person findById(String id) {
		Person person =mongoTemplate.findById(id, Person.class);
		return person;
	}
	
	
	@Override
	public List<Person> findAll() {
		return (List<Person>)mongoTemplate.findAll(Person.class);
	}

    }

