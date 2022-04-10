package com.example.server.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/get-person-information")
    public PersonDto getPersonById(@RequestBody PersonRequest request)
    {
        PersonDto personDto = personService.findPersonByPersonId(request.getId()).get();
        if (personDto != null)
            return personDto;
//        log.info(no person found by id 131112)
        return null;
    }

    @PostMapping("/get-all-people")
    public List<PersonDto> getAllPeople()
    {
        if (personService.findAll().size() != 0)
            return personService.findAllPeople();
        return null;
        //log.info("there is no people
    }
}
