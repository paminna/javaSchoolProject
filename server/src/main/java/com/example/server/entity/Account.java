package com.example.server.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * balance
     */
    private BigDecimal balance;

    /**
     * type of currency
     */
    private String type;

    /**
     * person data
     */
    @ManyToOne
    private Person person;

}
