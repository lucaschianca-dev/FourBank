package com.fourbank.bank.services;

import com.fourbank.bank.DTO.CustomerDTO;
import com.fourbank.bank.DTO.UpdateCustomerDTO;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.repositories.CustomerRepository;
import com.fourbank.bank.requests.CustomerRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional //Ele aparece quando você quer persistir algo no banco de dados
    public CustomerDTO registerCustomer (@Valid CustomerRegisterRequest request) {
        Customer customer = customerRepository.save(new Customer(request));
        return new CustomerDTO(customer);
    }

    public Page<CustomerDTO> listCustomers(Pageable pageable) {
        Page<CustomerDTO> activeCustomers = customerRepository.findAllByActiveTrue(pageable).map(CustomerDTO::new);
        return activeCustomers;
    }

    public CustomerDTO searchCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return new CustomerDTO(customer);
    }

    @Transactional
    public CustomerDTO updateCustomer(UpdateCustomerDTO update) {
        Customer customer = customerRepository.findById(update.id()).orElseThrow();
        customer.updateCustomer(update);
        return new CustomerDTO(customer);
    }
}
