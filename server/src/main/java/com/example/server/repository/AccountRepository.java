package com.example.server.repository;

import com.example.server.entity.Account;
import com.example.server.utils.JpaUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaUtil<Account, Integer> {
    List<Account> findAccountsByPersonId(Integer personId);

    Optional<Account> findAccountsByPerson_IdAndType(Integer id, String type);
}