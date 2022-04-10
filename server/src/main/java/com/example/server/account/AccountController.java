package com.example.server.account;

import com.example.server.person.PersonDto;
import com.example.server.person.PersonRequest;
import com.example.server.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    PersonService personService;

    @PostMapping("/get-accounts-by-person")
    public AccountDto getAccountById(@RequestBody PersonRequest request)
    {
//        Integer id = personService.findPersonByPersonId(request.getId()).get().getId();
        List<AccountDto> accounts = accountService.findAccountsByPersonId(personService.findPersonByPersonId(request.getId()).get().getId());
        if (accounts != null)
            return accounts.get(0);
//        log.info(no person found by id 131112)
        return null;
    }

    @GetMapping("/find-all-accounts")
    public List<AccountDto> findAllAccounts()
    {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        if (accountDtos.size() > 0)
            return accountDtos;
        return null;
    }

    @GetMapping("/find")
    public AccountDto getAccount()
    {
        List<AccountDto> accountDtos = accountService.findAllAccounts();
        return accountDtos.get(0);
    }
}
