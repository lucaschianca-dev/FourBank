package com.fourbank.bank.DTO;

import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {

    private Type type;

    private Customer customer;
}
