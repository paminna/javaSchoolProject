package com.example.client.client;

import com.example.server.account.AccountDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {
//    List<ClientDto> getAccountById (Integer id);
//
    List<AccountDto> findAllAccounts();
}
