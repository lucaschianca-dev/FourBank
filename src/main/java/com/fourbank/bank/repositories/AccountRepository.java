package com.fourbank.bank.repositories;

import com.fourbank.bank.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNumber(String number);
}