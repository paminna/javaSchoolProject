package com.example.server.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Person {
    /**
     * id человека в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
     * отчество человека
     */
    private String fullName;

    /**
     * дата рождения
     */
    private Date birthday;


    private String login;

    private String password;

    private Boolean enable;

}
