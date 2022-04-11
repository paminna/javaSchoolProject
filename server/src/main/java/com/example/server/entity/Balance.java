package com.example.server.entity;

import com.example.server.entity.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Balance {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    private BigDecimal balance;

    @ManyToOne
    private Account account;
}
