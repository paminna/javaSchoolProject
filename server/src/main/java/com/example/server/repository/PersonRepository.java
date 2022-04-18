package com.example.server.repository;

import com.example.server.entity.Person;
import com.example.server.utils.JpaUtil;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DAO для работы с таблицей person
 */
@Repository
public interface PersonRepository extends JpaUtil<Person, Long> {

    Optional<Person> findPersonById(Integer personId);

    Optional<Person> findPersonByLoginAndPassword(String login, String password);

}
