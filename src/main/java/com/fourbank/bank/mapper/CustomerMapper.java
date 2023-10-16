package com.fourbank.bank.mapper;

import com.fourbank.bank.DTO.CustomerDTO;
import com.fourbank.bank.domain.entities.Customer;
import com.fourbank.bank.requests.CustomerRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    //Instancia para pegar o mapeamento da minha classe

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerRegisterRequest request);

    CustomerDTO toCustomerDTO(Customer customer);
}
