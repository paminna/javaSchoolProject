package com.example.server.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "accounts")
public class Account {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * account id
     */
//    @Column(name = "accountId")
    private String accountId;

    /**
     * amount of money
     */
    @OneToMany(mappedBy = "account")
    private Set<Balance> balance = new HashSet<Balance>();

    /**
     * person data
     */
    @ManyToOne
    private Person person;

//    private String personId;
}
