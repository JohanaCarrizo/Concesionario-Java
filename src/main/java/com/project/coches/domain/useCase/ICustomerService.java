package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.response.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerResponseDto save(CustomerDto newCustomerDto);

    Optional<CustomerDto> update(CustomerDto newCustomerDto);

    boolean delete(String cardId);
}
