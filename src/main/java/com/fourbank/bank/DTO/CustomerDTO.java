package com.fourbank.bank.DTO;

import com.fourbank.bank.domain.address.Address;
import com.fourbank.bank.domain.entities.Account;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.enums.Benefit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

    private String name;

    private String cpf;

    private String phone;

    private Benefit benefit;

    private Address addresses;

    private Account accounts;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.cpf = customer.getCpf();
        this.phone = customer.getPhone();
        this.benefit = customer.getBenefit();
        this.addresses = customer.getAddresses();
        this.accounts = customer.getAccounts();
    }
}
