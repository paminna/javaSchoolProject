package com.example.server.service;

import static org.mockito.Mockito.when;

import com.example.server.dto.AccountDto;
import com.example.server.dto.PersonDto;
import com.example.server.entity.Account;
import com.example.server.entity.Person;
import com.example.server.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepositoryMock;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        personRepositoryMock = Mockito.mock(PersonRepository.class);
        personService = new PersonServiceImpl();
    }

    @Test
    public void toDtoSuccess(){
        PersonDto personDto = new PersonDto();
        Person entity = new Person();
        when(personService.toDto(entity)).thenReturn(personDto);
        Assert.assertEquals(personDto, personService.toDto(entity));
    }

    @Test
    public void getAllUsersTest() {
        List<Person> usersFromMock = personRepositoryMock.findAll();
        List<PersonDto> users = new ArrayList<>();
        when(personService.findAllPeople()).thenReturn(users);
        Assert.assertEquals(usersFromMock, users);
    }

    @Test
    public void findPersonById() {
        Person person = new Person();
        person.setName("Иван");
        when(personRepositoryMock.findPersonById(1)).thenReturn(Optional.of(person));
        Assert.assertEquals(Optional.of(person), personRepositoryMock.findPersonById(1));
    }

    @Test
    public void PersonNotFoundById() {
        when(personRepositoryMock.findPersonById(132)).thenReturn(null);
        Assert.assertEquals(null, personRepositoryMock.findPersonById(132));
    }

    @Test
    public void PersonByLogin(){
        Optional<Person> person = Optional.of(new Person());
        when(personRepositoryMock.findPersonByLogin("ivan")).thenReturn(person);
        Assert.assertEquals(person, personRepositoryMock.findPersonByLogin("ivan"));
    }
}
