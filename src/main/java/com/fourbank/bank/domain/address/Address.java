package com.fourbank.bank.domain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fourbank.bank.domain.entities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "adresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String cep;

    private String number;

    private String uf;

    @OneToMany(mappedBy = "addresses") //Aqui eu estou voltando para o cliente, pelo atributo que criamos la
    @JsonBackReference
    private List<Customer> customer;
}
