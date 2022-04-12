package com.example.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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
