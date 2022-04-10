package com.example.server.person;


//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//@EnableWebSecurity

//@NoArgsConstructor
//@AllArgsConstructor
@Service
public class PersonService  extends JpaService<Person, Long, PersonRepository, PersonDto>{

    @Autowired
    ModelMapper modelMapper;

    protected PersonService() {
        super(PersonRepository.class, Person.class, PersonDto.class);
    }


    private PersonDto toDto(Person person) {
        PersonDto postDto = modelMapper.map(person, PersonDto.class);
        return postDto;
    }

    public Optional<PersonDto> findPersonByPersonId(String personId)
    {
        return getDao().findPersonByPersonId(personId).map(this::toDto);
    }

    public List<PersonDto> findAllPeople()
    {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }


}