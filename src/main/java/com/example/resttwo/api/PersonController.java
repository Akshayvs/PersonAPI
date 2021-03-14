package com.example.resttwo.api;

import com.example.resttwo.model.Person;
import com.example.resttwo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController (PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson (@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping (path = "/{id}")
    public Optional<Person> getPersonById (@PathVariable("id") UUID id) {
        return personService.selectPersonById(id);
    }



}
