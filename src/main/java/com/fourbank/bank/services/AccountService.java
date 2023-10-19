package com.fourbank.bank.services;

import com.fourbank.bank.DTO.AccountDetailedDTO;
import com.fourbank.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Page<AccountDetailedDTO> listAccounts(Pageable pageable) {
        Page<AccountDetailedDTO> activeAccounts = accountRepository.findAll(pageable).map(AccountDetailedDTO::new);

        return activeAccounts;
    }
}
