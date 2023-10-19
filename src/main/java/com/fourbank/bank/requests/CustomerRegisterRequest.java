package com.fourbank.bank.requests;

import com.fourbank.bank.DTO.AccountDTO;
import com.fourbank.bank.domain.address.Address;
import com.fourbank.bank.enums.Benefit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequest {

    private String name;

    private String cpf;

    private String phone;

    private Benefit benefit;

    private Address addresses;

    private AccountDTO accounts;
}
