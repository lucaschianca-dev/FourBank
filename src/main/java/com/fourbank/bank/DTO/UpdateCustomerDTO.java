package com.fourbank.bank.DTO;

import com.fourbank.bank.domain.address.Address;
import com.fourbank.bank.enums.Benefit;
import jakarta.validation.constraints.NotNull;

public record UpdateCustomerDTO(
        @NotNull
        Long id,
        String phone,

        Benefit benefit,

        Address addresses
) {
}
