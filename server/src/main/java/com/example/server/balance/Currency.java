package com.example.server.balance;

import com.example.server.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Currency {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    private BigDecimal balance;

    @ManyToOne
    private Account account;
}
