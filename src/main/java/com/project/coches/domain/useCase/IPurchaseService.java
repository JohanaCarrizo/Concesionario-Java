package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.response.PurchaseBillResponseDto;
import com.project.coches.domain.dto.response.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseService {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
