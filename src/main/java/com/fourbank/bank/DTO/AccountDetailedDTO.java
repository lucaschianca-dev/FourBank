package com.fourbank.bank.DTO;

import com.fourbank.bank.domain.entities.Account;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailedDTO {

    private Long id;

    private String number;

    private Type type;

    private BigDecimal balance;

    private Customer customer;

    public AccountDetailedDTO(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.type = account.getType();
        this.balance = account.getBalance();
        this.customer = account.getCustomer();
    }
}
