package com.example.server.balance;

import com.example.server.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceDto {
    @JsonIgnore
    private Integer id;

    private String type;

    private BigDecimal balance;

    @JsonIgnore
    private Account account;
}
