package org.danielreed.controller;


import org.danielreed.dao.PersonDao;
import org.danielreed.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/people")
@PreAuthorize("isAuthenticated()")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable int personId) {

        Person person = personDao.getPersonById(personId);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found.");
        }

        return person;
    }
}
