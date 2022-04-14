package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import com.example.server.repository.AccountRepository;
import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl extends JpaService<Account, Integer, AccountRepository, AccountDto> implements AccountService {

    @Autowired
    ModelMapper modelMapper;

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
}
