package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.dto.PersonDto;
import com.example.server.entity.Account;
import com.example.server.repository.AccountRepository;
import com.example.server.utils.JpaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.servlet.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Service
public class AccountServiceImpl extends JpaService<Account, Integer, AccountRepository, AccountDto> implements AccountService {

    @Autowired
    private  ModelMapper modelMapper;

    @Autowired
    private PersonServiceImpl personService;

    protected AccountServiceImpl() {
        super(AccountRepository.class, Account.class, AccountDto.class);
    }

    @Override
    public AccountDto toDto(Account account) {
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return accountDto;
    }

    @Override
    public List<AccountDto> findAccountsByPersonId(Integer personId) {
        return getDao().findAccountsByPersonId(personId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAccountsByPin(String login, String password)
    {
        Optional<PersonDto> person = personService.findPersonByLoginAndPassword(login, password);
        Integer personId = person.isPresent() ? person.get().getId() : null;
        if (personId != null) {
            List<AccountDto> accounts = this.findAccountsByPersonId(personId);
            if (accounts != null)
                return accounts;
            log.info("No accounts found by person id " + personId.toString());
        }
        log.info("No person id found by id " + personId.toString());
        return null;
    }
}
