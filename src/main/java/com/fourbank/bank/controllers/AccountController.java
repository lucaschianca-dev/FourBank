package com.fourbank.bank.controllers;

import com.fourbank.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity listAccountss() {
        var activeAccounts = accountService.listAccounts();
        return ResponseEntity.ok(activeAccounts);
    }
}
