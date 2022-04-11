package com.example.client.client.dto;

import com.example.server.dto.BalanceDto;
import com.example.server.dto.PersonDto;
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
