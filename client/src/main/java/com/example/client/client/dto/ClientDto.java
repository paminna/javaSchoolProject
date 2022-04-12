package com.example.client.client.dto;

import com.example.server.dto.PersonDto;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
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

    private BigDecimal balance;

    private String type;
}
