package com.example.server.service;

import com.example.server.dto.PersonDto;
import com.example.server.entity.Person;
import com.example.server.repository.PersonRepository;
import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl extends JpaService<Person, Long, PersonRepository, PersonDto> implements PersonService{
    @Autowired
    ModelMapper modelMapper;

    public PersonServiceImpl() {
        super(PersonRepository.class, Person.class, PersonDto.class);
    }

    @Override
    public PersonDto toDto(Person person) {
        PersonDto postDto = modelMapper.map(person, PersonDto.class);
        return postDto;
    }

    @Override
    public Optional<PersonDto> findPersonById(Integer personId) {
        return getDao().findPersonById(personId).map(this::toDto);
    }

    @Override
    public List<PersonDto> findAllPeople() {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}
