package com.example.server.repository;

import com.example.server.entity.Account;
import com.example.server.utils.JpaUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account>, JpaUtil<Account, Integer> {
    List<Account> findAccountsByPersonId(Integer personId);

    List<Account> findAll();
}