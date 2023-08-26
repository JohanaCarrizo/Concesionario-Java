package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.response.PurchaseBillResponseDto;
import com.project.coches.domain.dto.response.PurchaseResponseDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.domain.useCase.IPurchaseUseCase;
import com.project.coches.exception.PurchaseNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PurchaseService implements IPurchaseUseCase {

    private final IPurchaseRepository iPurchaseRepository;

    private final ICarRepository iCarRepository;

    @Override
    public List<PurchaseResponseDto> getAll() {
        return iPurchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return iPurchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        PurchaseResponseDto purchaseResponseDto = iPurchaseRepository.getByNumberBill(numberBill);

        if (purchaseResponseDto == null) {
            throw new PurchaseNotExistException();
        }

        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseBillResponseDto billResponseDto = iPurchaseRepository.save(purchaseRequestDto);

        purchaseRequestDto.getCarsPurchases().forEach(carPurchase -> {
            CarDto carActual = iCarRepository.getCar(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantityCars());

            iCarRepository.save(carActual);
        });

        return billResponseDto;
    }
}
