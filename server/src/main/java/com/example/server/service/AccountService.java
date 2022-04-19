package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import java.util.List;
import java.util.Optional;

/**
 * interface for accountServiceImpl
 */
public interface AccountService {

    AccountDto toDto(Account account);

    List<AccountDto> findAccountsByPersonId(Integer personId);

    List<AccountDto> findAllAccounts();

    Optional<AccountDto> findAccountByPerson_IdAndType(Integer id, String type);

    List<AccountDto> getAccountByLogin(String login, String password);

    String convert(String from, String to, String login);
}
