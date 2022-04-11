package com.example.server.entity;


import com.example.server.entity.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@Table(name = "person")
public class Person {
    /**
     * id человека в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Integer id;

    /**
     * персональный id человека
     */
//    @Column(name = "personId")
    private String personId;

    /**
     * имя человека
     */
//    @Column(name = "name")
    private String name;

    /**
     * фамилия человека
     */
//    @Column(name = "surname")
    private String surname;

    /**
     * отчество человека
     */
//    @Column(name = "patronymic")
    private String patronymic;

    /**
     * отчество человека
     */
//    @Column(name = "full_name")
    private String fullName;

    /**
     * дата рождения
     */
//    @Column(name = "birthday")
    private Date birthday;

    /**
     * счет в банке
     */
    @OneToMany(mappedBy = "person")
    private Set<Account> account = new HashSet<Account>();

}
