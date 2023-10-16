package com.fourbank.bank.controllers;

import com.fourbank.bank.DTO.CustomerDTO;
import com.fourbank.bank.requests.CustomerRegisterRequest;
import com.fourbank.bank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity registerCustomer(@RequestBody CustomerRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(request));
    }

    @GetMapping("/all")
    public ResponseEntity listCustomers() {
        var listCustomers = customerService.listCustomers();
        return ResponseEntity.ok(listCustomers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> searchCustomer(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);

        if (customerDTO != null) {
            return ResponseEntity.ok(customerDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
