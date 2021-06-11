package com.edirley.personapi.controllers;

import com.edirley.personapi.dto.request.PersonDTO;
import com.edirley.personapi.dto.response.MessageResponseDTO;
import com.edirley.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

}
//    private final PersonService personService;
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
//        return personService.create(personDTO);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
//        return personService.findById(id);
//    }
//
//    @GetMapping
//    public List<PersonDTO> listAll() {
//        return personService.listAll();
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
//        return personService.update(id, personDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) throws PersonNotFoundException {
//        personService.delete(id);
//    }

