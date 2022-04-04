package com.example.server.person;

import com.example.server.account.Account;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

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
    private Long personId;

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
    private Account account;

    /**
     * дата рождения
     */
    private Date birthday;

}
