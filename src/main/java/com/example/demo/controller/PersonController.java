package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class PersonController {

    @Autowired
    PersonService personService;

    //Person Controller to give all the details of person

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String create(@RequestBody Person person){
        return personService.create(person);
    }
    @RequestMapping(value = "/person/id", method = RequestMethod.GET)
    public Person retrieveById(@RequestParam int personId){
        return personService.retrieveById(personId);
    }
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> retrieve(){
        return personService.retrieve();
    }
    @RequestMapping(value = "/person/search", method = RequestMethod.GET)
    public List<Person> search(@RequestParam Map<String,String> allParams){

        return personService.search(allParams);
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public String update(@RequestBody Person person, @RequestParam int personId){
        return personService.update(person, personId);
    }
    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    public String delete(@RequestParam int personId){
        return personService.delete(personId);
    }
}
