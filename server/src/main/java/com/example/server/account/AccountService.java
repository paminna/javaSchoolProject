package com.example.server.account;

import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService extends JpaService<Account, Integer, AccountRepository, AccountDto> {

    @Autowired
    ModelMapper modelMapper;

    protected AccountService() {
        super(AccountRepository.class, Account.class, AccountDto.class);
    }

    private AccountDto toDto(Account account) {
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return accountDto;
    }

    public List<AccountDto> findAccountsByPersonId(Integer personId){
        return getDao().findAccountsByPersonId(personId).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<AccountDto> findAllAccounts()
    {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

}
