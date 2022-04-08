package com.example.server.account;

import com.example.server.person.Person;
import com.example.server.person.PersonDto;
import com.example.server.person.PersonRepository;
import com.example.server.utils.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

public class AccountService extends JpaService<Account, Integer, AccountRepository, AccountDto> {


    protected AccountService() {
        super(AccountRepository.class, Account.class, AccountDto.class);
    }
//
//    private AccountDto toDto(Account account) {
//        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
//        return accountDto;
//    }

    public AccountDto findAccountByPersonId(String personId){
        return null;
    }
}
