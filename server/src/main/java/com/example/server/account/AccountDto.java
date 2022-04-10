package com.example.server.account;

import com.example.server.balance.BalanceDto;
import com.example.server.person.PersonDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class AccountDto {

    @JsonIgnore
    private Integer id;

    /**
     * номер карты/счета
     */
    private String accountId;

//    private String personId;

    @JsonIgnore
    private PersonDto personDto;

    @JsonUnwrapped
    private Set<BalanceDto> balance;
}
