package com.avenuecode.webmvcapp.controllers;

import com.avenuecode.webmvcapp.domain.Person;
import com.avenuecode.webmvcapp.services.PersonService;
import com.avenuecode.webmvcapp.services.templat.PersonServiceTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;
    private PersonServiceTemplate personServiceTemplate;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/api/v1/persons/{id}")
    public ResponseEntity<Person> findById(@PathVariable String id){
        return ResponseEntity.ok(this.personService.findById(id));
    }
    
    @GetMapping("/api/v1/personstemplate/{id}")
    public ResponseEntity<Person> findById1(@PathVariable String id){
        return ResponseEntity.ok(this.personServiceTemplate.findById(id));
    }
    
  
    @GetMapping("/api/v1/persons")
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(this.personService.findAll());
    }
    
    @GetMapping("/api/v1/personstemplate")
    public ResponseEntity<List<Person>> findAll1(){
        return ResponseEntity.ok(this.personServiceTemplate.findAll());
    }

    @PostMapping("/api/v1/persons")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return ResponseEntity.ok(this.personService.save(person));
    }
    
    
    
    @PostMapping("/api/v1/personstemplate")
    public void save1(@RequestBody Person person){
         personServiceTemplate.create(person);
    }
    
      @PutMapping("/api/v1/personstemplate/{id}")
    public void update1(@PathVariable String id, @RequestBody Person person){
       
        personService.update(person);
    }

    @DeleteMapping("/api/v1/persons/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        this.personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
