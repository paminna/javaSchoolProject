package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import com.example.server.repository.AccountRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountServiceMock;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        accountServiceMock = new AccountServiceImpl();
    }

    @Test
    public void toDtoSuccess(){
        AccountDto account = new AccountDto();
        Account entity = new Account();
        when(accountServiceMock.toDto(entity)).thenReturn(account);
        Assert.assertEquals(account, accountServiceMock.toDto(entity));
    }

    @Test
    public void foundAccountsByPersonId() {
        List<Account> account = accountRepository.findAccountsByPersonId(1);
        when(accountRepository.findAccountsByPersonId(1)).thenReturn(account);
        Assert.assertEquals(account, accountRepository.findAccountsByPersonId(1));
    }

    @Test
    public void AccountsNotFound() {
        List<AccountDto> accounts = new ArrayList<>();
        when(accountServiceMock.findAccountsByPersonId(1)).thenReturn(accounts);
        Assert.assertNotEquals(null, accountServiceMock.findAccountsByPersonId(1));
    }

    @Test
    public void findAllAccounts() {
        List<AccountDto> accountDtos = new ArrayList<>();
        when(accountServiceMock.findAllAccounts()).thenReturn(accountDtos);
        Assert.assertEquals(accountDtos, accountServiceMock.findAllAccounts());
    }
}