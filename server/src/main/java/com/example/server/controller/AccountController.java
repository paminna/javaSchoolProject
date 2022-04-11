package com.example.server.controller;

import com.example.server.dto.AccountDto;
import com.example.server.service.AccountService;
import com.example.server.service.PersonService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    PersonService personService;

    /**
     * вывод аккаунтов клиента по его личному айди
     * @param id person
     * @return List<AccountDto>
     */
    @GetMapping("/get-accounts-by/{id}")
    public List<AccountDto> getAccountById(@PathVariable("id") String id) {
        Integer personId = personService.findPersonByPersonId(id).isPresent() ? personService.findPersonByPersonId(id).get().getId() : null;
        if (id != null) {
            List<AccountDto> accounts = accountService.findAccountsByPersonId(personId);
            if (accounts != null)
                return accounts;
            log.info("No accounts found by person id " + personId);
        }
        log.info("No person id found by id " + id.toString());
        return null;
    }

    @GetMapping("/find-all-accounts")
    public List<AccountDto> findAllAccounts()
    {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        if (accountDtos.size() > 0)
            return accountDtos;
        log.info("There is no accounts");
        return null;
    }

    @GetMapping("/find")
    public AccountDto getAccount()
    {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        return accountDtos.get(0);
    }
}
