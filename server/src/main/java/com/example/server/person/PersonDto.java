package com.example.server.person;

import com.example.server.account.Account;
import com.example.server.account.AccountDto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Setter
@Getter

public class PersonDto{

    /**
     * id в таблице
     */
    private Long id;

    /**
     * персональный id человека
     */
    private String personId;

    /**
     * имя человека
     */
    private String name;

    /**
     * фамилия человека
     */
    private String surname;

    /**
     * отчество человека
     */
    private String patronymic;

    /**
     * счет в банке
     */
    private Set<AccountDto> account;

    /**
     * дата рождения
     */
    private Date birthday;

}
