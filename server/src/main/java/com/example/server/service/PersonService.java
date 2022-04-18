package com.example.server.service;

import com.example.server.dto.PersonDto;
import com.example.server.entity.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    PersonDto toDto(Person person);

    Optional<PersonDto> findPersonById(Integer personId);

    List<PersonDto> findAllPeople();

    Optional<PersonDto> findPersonByLoginAndPassword(String login, String password);
}
