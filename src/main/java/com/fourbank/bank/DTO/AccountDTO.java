package com.fourbank.bank.DTO;

import com.fourbank.bank.domain.entities.Account;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Type type;

    private Customer customer;

    public AccountDTO(Account account) {
        this.type = account.getType();
        this.customer = account.getCustomer();
    }
}
