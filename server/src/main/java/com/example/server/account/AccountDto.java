package com.example.server.account;

import com.example.server.balance.Currency;
import com.example.server.balance.CurrencyDto;
import com.example.server.person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Integer id;

    /**
     * номер карты/счета
     */
    private String accountId;

    private PersonDto personDto;

    private List<CurrencyDto> balance;
}
