package com.example.server.controller;

import com.example.server.dto.AccountDto;
import com.example.server.service.AccountServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.server.service.PersonServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    PersonServiceImpl personService;

    /**
     * вывод аккаунтов клиента по его личному айди
     *
     * @param id person
     * @return List<AccountDto>
     */
    @GetMapping("/get-accounts-by/{id}")
    public List<AccountDto> getAccountById(@PathVariable("id") Integer id) {
        Integer personId = personService.findPersonById(id).isPresent() ? personService.findPersonById(id).get().getId() : null;
        if (id != null) {
            List<AccountDto> accounts = accountService.findAccountsByPersonId(personId);
            if (accounts != null)
                return accounts;
            log.info("No accounts found by person id " + personId.toString());
        }
        log.info("No person id found by id " + id.toString());
        return null;
    }

    @GetMapping("/find-all-accounts")
    public List<AccountDto> findAllAccounts() {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        if (accountDtos.size() > 0)
            return accountDtos;
        log.info("There is no accounts");
        return null;
    }
}
