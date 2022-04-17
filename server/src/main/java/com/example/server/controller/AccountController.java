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

    /**
     * вывод аккаунтов клиента по его личному айди
     *
     * @return List<AccountDto>
     */
    @GetMapping("/get-accounts-by")
    public List<AccountDto> getAccountById(@RequestParam("login") String login, @RequestParam("password") String password) {
        return accountService.findAccountsByPin(login, password);
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
