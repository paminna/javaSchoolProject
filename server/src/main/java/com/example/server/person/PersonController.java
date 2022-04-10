package com.example.server.person;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/server")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/get-person-information")
    public PersonDto getPersonById(@RequestBody PersonRequest request)
    {
        PersonDto personDto = personService.findPersonByPersonId(request.getId()).isPresent() ? personService.findPersonByPersonId(request.getId()).get() : null;
        if (personDto != null)
            return personDto;
        log.info("Couldn't find person by id" + request.getId());
        return null;
    }

    @PostMapping("/get-all-people")
    public List<PersonDto> getAllPeople()
    {
        if (personService.findAll().size() != 0)
            return personService.findAllPeople();
        log.info("There is no accounts yet");
        return null;
    }
}
