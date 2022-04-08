package com.example.server.account;

import com.example.server.balance.Currency;
import com.example.server.person.Person;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private List<Currency> currencies = new ArrayList<>();

    /**
     * person data
     */
    @ManyToOne
    private Person person;
}
