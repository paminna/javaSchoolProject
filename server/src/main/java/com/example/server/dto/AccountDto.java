package com.example.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class AccountDto {

//    @JsonIgnore
    private Integer id;

    /**
     * номер карты/счета
     */
    private String accountId;

//    private String personId;

//    @JsonIgnore
    private PersonDto personDto;

//    @JsonUnwrapped
    private Set<BalanceDto> balance;
}
