package com.example.server.account;

import com.example.server.person.Person;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "account")
public class Account {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * account id
     */
    @Column(name = "accountId")
    private Long accountId;

    /**
     * amount of money
     */
    @Column(name = "balance")
    private BigDecimal balance;

    /**
     * person data
     */
    @ManyToOne
    private Person person;
}
