package com.fourbank.bank.services;

import com.fourbank.bank.DTO.CustomerDTO;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.repositories.CustomerRepository;
import com.fourbank.bank.requests.CustomerRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO registerCustomer (@Valid CustomerRegisterRequest request) {
        Customer customer = customerRepository.save(new Customer(request));
        return new CustomerDTO(customer);
    }

    public List<CustomerDTO> listCustomers() {
        List<CustomerDTO> activeCustomers = customerRepository.findAllByActiveTrue()
                .stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());

        return activeCustomers;
    }

    public CustomerDTO searchCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return new CustomerDTO(customer);
    }
}
