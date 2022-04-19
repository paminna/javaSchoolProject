package com.example.server.controller;

import com.example.server.dto.AccountDto;
import com.example.server.service.AccountServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.server.service.PersonServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
     * @param login,password person
     * @return List<AccountDto>
     */
    @GetMapping("/get-accounts-by/{login}/{password}")
    public List<AccountDto> getAccount(
            @PathVariable("login") String login,
            @PathVariable("password") String password) {
        return accountService.getAccountByLogin(login, password);
    }

    /**
     * возвращает список всех аккаунтов из базы данных
     * @return
     */
    @GetMapping("/find-all-accounts")
    public List<AccountDto> findAllAccounts() {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        if (accountDtos.size() > 0)
            return accountDtos;
        log.info("There is no accounts");
        return new ArrayList<>();
    }

    /**
     * конвертация рубля в евро/доллар
     * @param from что конвертируем (рубль)
     * @param to в какую валюту конвертируем
     * @param login человека для поиска аккаунта
     * @return
     */
    @GetMapping("convert/{from}/{to}/by/{login}")
    public String  converter(@PathVariable("from") String from,
                             @PathVariable("to") String to,
                             @PathVariable("login") String login){
        return accountService.convert(from, to, login);
    }
}
