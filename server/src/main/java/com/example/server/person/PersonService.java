package com.example.server.person;


//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//@EnableWebSecurity
@Service
public class PersonService extends JpaService<Person, Long, PersonRepository> {

    @Autowired
    ModelMapper modelMapper;


    protected PersonService() {
        super();
    }

    private PersonDto toDto(Person person) {
        PersonDto postDto = modelMapper.map(person, PersonDto.class);
        return postDto;
    }


    public List<PersonDto> getPersonByPersonId(Long personId)
    {
        return getDao().getPersonByPersonId(personId).stream().map(this::toDto).collect(Collectors.toList());
    }
}