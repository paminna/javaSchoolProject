package com.example.client.client;

import com.example.server.balance.BalanceDto;
import com.example.server.person.PersonDto;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class ClientDto {
    private Integer id;

    /**
     * номер карты/счета
     */
    private String accountId;

    private PersonDto personDto;

    private Set<BalanceDto> balance;
}
