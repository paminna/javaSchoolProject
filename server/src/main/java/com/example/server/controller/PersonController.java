package com.example.server.controller;

import com.example.server.AuthRequest;
import com.example.server.dto.PersonDto;
import com.example.server.person.PersonRequest;
import com.example.server.security.JwtService;
import com.example.server.service.PersonServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Log
@RestController
public class PersonController {
    @Autowired
    PersonServiceImpl personService;

    @Autowired
    private JwtService jwt;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/get-person-information/{id}")
    public PersonDto getPersonById(@PathVariable("id") Integer id) {
        PersonDto personDto = personService.findPersonById(id).isPresent() ? personService.findPersonById(id).get() : null;
        if (personDto != null)
            return personDto;
        log.info("Couldn't find person by id" + id.toString());
        return null;
    }

    @GetMapping("/get-all-people")
    public List<PersonDto> getAllPeople() {
        if (personService.findAll().size() != 0)
            return personService.findAllPeople();
        log.info("There is no accounts yet");
        return null;
    }

    @GetMapping("/")
    public String sayHello(){
        return "hello, you are in server";
    }

//    @PostMapping("/authenticate")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
////        try {
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())
////            );
////        } catch (Exception ex) {
////            throw new Exception("inavalid username/password");
////        }
////        return jwt.generateToken(authRequest.getLogin());
//    }
}
