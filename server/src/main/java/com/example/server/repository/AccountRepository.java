package com.example.server.repository;

import com.example.server.entity.Account;
import com.example.server.utils.JpaUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с таблицей аккаунта
 */
@Repository
public interface AccountRepository extends JpaUtil<Account, Integer> {

    List<Account> findAccountsByPersonId(Integer personId);

    Optional<Account> findAccountByPerson_IdAndType(Integer id, String type);
}