package com.fourbank.bank.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fourbank.bank.DTO.AccountDTO;
import com.fourbank.bank.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private Type type;

    private BigDecimal balance;

    @OneToOne(mappedBy = "accounts")
    @JsonBackReference
    private Customer customer;

    public Account(AccountDTO accountsDTO) {
        this.number = UUID.randomUUID().toString();
        this.type = accountsDTO.getType();
        this.balance = BigDecimal.ZERO;
    }
}
