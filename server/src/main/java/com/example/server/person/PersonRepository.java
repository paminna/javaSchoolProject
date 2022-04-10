package com.example.server.person;


import com.example.server.utils.JpaUtil;
//import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaUtil<Person, Long> {
    Optional<Person> findPersonByPersonId(String personId);
}
