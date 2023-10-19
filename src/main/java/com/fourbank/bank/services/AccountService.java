package com.fourbank.bank.services;

import com.fourbank.bank.DTO.AccountDetailedDTO;
import com.fourbank.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<AccountDetailedDTO> listAccounts() {
        List<AccountDetailedDTO> activeAccounts = accountRepository.findAll()
                .stream()
                .map(AccountDetailedDTO::new)
                .collect(Collectors.toList());

        return activeAccounts;
    }
}
