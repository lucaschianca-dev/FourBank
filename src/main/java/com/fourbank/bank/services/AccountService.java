package com.fourbank.bank.services;

import com.fourbank.bank.DTO.AccountDTO;
import com.fourbank.bank.DTO.AccountDetailedDTO;
import com.fourbank.bank.domain.entities.Account;
import com.fourbank.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Page<AccountDetailedDTO> listAccounts(Pageable pageable) {
        Page<AccountDetailedDTO> activeAccounts = accountRepository.findAll(pageable).map(AccountDetailedDTO::new);

        return activeAccounts;
    }

    public AccountDetailedDTO findAccountByCpf(String number) {
        Account account = accountRepository.findByNumber(number);
        return new AccountDetailedDTO(account);
    }
}
