package com.fourbank.bank.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fourbank.bank.DTO.AccountsDTO;
import com.fourbank.bank.DTO.UpdateCustomerDTO;
import com.fourbank.bank.domain.address.Address;
import com.fourbank.bank.enums.Benefit;
import com.fourbank.bank.requests.CustomerRegisterRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Benefit benefit;

    private boolean active;

    @ManyToOne(cascade = CascadeType.ALL) //MANY = Customer AND ONE = Address -- Muitos clinentes para um enderesso
    @JoinColumn(name = "addresses_id") //Aqui eu estou INDO para o endereco
    @JsonIgnore
    private Address addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id")
    @JsonIgnore
    private Account accounts;

    public Customer(CustomerRegisterRequest request) {
        this.name = request.getName();
        this.cpf = request.getCpf();
        this.phone = request.getPhone();
        this.benefit = request.getBenefit();
        this.addresses = request.getAddresses();
        this.accounts = new Account(request.getAccounts());
        this.active = true;
    }

    public void updateCustomer(UpdateCustomerDTO update) {
        if (update.id() == null) {
        } else {
            if (update.phone() != null)
                this.phone = update.phone();
            if (update.benefit() != null)
                this.phone = update.phone();
            if (update.addresses() != null)
                this.addresses = update.addresses();
        }
    }
}
