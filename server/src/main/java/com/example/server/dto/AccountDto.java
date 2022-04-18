package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {

    /**
     * id in table
     */
    private Integer id;

    /**
     * номер карты/счета
     */
    private String accountId;

    /**
     * данные о человеке
     */
    private PersonDto personDto;

    /**
     * тип валюты
     */
    private String type;

    /**
     * баланс
     */
    private BigDecimal balance;
}
