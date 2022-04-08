package com.example.server.balance;

import com.example.server.account.Account;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyDto {
    private Integer id;

    private String typeOfCurrency;

    private BigDecimal balance;

    private Account account;

}
