package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    AccountDto toDto(Account account);

    List<AccountDto> findAccountsByPersonId(Integer personId);

    List<AccountDto> findAllAccounts();

    Optional<AccountDto> findAccountsByPerson_IdAndType(Integer id, String type);
}
