package com.example.server.account;

import com.example.server.utils.JpaUtil;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaUtil<Account, Integer> {
    List<Account> findAccountsByPersonId(Integer personId);

    List<Account> findAll();
}