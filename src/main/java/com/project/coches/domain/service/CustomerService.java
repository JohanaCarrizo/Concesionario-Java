package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.response.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService{

    private final ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomerDto) {

        if(!newCustomerDto.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            throw new EmailValidationException();
        }

        String passwordGenerated = generateRandomPassword(8);
        newCustomerDto.setPassword(passwordGenerated);
        newCustomerDto.setActive(1);
        iCustomerRepository.save(newCustomerDto);
        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto editCustomerDto) {
        if(iCustomerRepository.getCustomerByCardId(editCustomerDto.getCardId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(editCustomerDto));
    }

    @Override
    public boolean delete(String cardId) {
        if(iCustomerRepository.getCustomerByCardId(cardId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;
    }

    private String generateRandomPassword(int len){

        final String chars = "ABCDEFGHIJKLMNSOPQRSTWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){

            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
