package com.example.server.person;


import com.example.server.utils.JpaUtil;
//import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaUtil<Person, Long> {
    @Query("select p as person from Person p where p.personId=?1")
    List<Person> getPersonByPersonId(Long personId);
}
