package com.example.server.controller;

import com.example.server.dto.PersonDto;
import com.example.server.service.PersonServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/server")
public class PersonController {
    @Autowired
    PersonServiceImpl personService;

    /**
     * возвращает информацию о человеке по id
     * @param id
     * @return
     */
    @GetMapping("/get-person-information/{id}")
    public PersonDto getPersonById(@PathVariable("id") Integer id) {
        PersonDto personDto = personService.findPersonById(id).isPresent()
                ? personService.findPersonById(id).get() : null;
        if (personDto != null)
            return personDto;
        log.info("Couldn't find person by id" + id.toString());
        return null;
    }

    /**
     * возвращает список всех пользователей
     * @return
     */
    @GetMapping("/get-all-people")
    public List<PersonDto> getAllPeople() {
        if (personService.findAll().size() != 0)
            return personService.findAllPeople();
        log.info("There is no accounts yet");
        return null;
    }
}
