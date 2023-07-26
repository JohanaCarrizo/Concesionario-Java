package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.response.CarPurchaseResponseDto;
import com.project.coches.domain.dto.response.PurchaseBillResponseDto;
import com.project.coches.domain.dto.response.PurchaseResponseDto;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.persistance.crud.IPurchaseCrudRepository;
import com.project.coches.persistance.entity.PurchaseEntity;
import com.project.coches.persistance.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository iPurchaseCrudRepository;

    private final IPurchaseMapper iPurchaseMapper;
    @Override
    public List<PurchaseResponseDto> getAll() {

        List<PurchaseEntity> listPurchaseEntities = iPurchaseCrudRepository.findAll();
        List<PurchaseResponseDto> purchaseResponseDtoList = new ArrayList<>();
        listPurchaseEntities.forEach(purchaseEntity -> purchaseResponseDtoList.add(toPurchaseResponseDtoByEntity(purchaseEntity)));
        return purchaseResponseDtoList;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        List<PurchaseEntity> listPurchaseEntities = iPurchaseCrudRepository.findAllByCardIdCustomer(idCustomer);
        List<PurchaseResponseDto> purchaseResponseDtoList = new ArrayList<>();
        listPurchaseEntities.forEach(purchaseEntity -> purchaseResponseDtoList.add(toPurchaseResponseDtoByEntity(purchaseEntity)));
        return purchaseResponseDtoList;
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        Optional<PurchaseEntity> purchaseEntity = iPurchaseCrudRepository.findById(numberBill);
        return purchaseEntity.map(this::toPurchaseResponseDtoByEntity).orElse(null);
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDto);
        purchaseEntity.getCarsPurchases().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = iPurchaseCrudRepository.save(purchaseEntity);
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }

    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity) {
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardIdCustomer(purchaseEntity.getCardIdCustomer());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarsPurchases().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantityCars();
            Integer total = carPurchaseEntity.getTotal();
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));
        });

        purchaseResponseDto.setCarsPurchases(carPurchaseResponseDtoList);

        return purchaseResponseDto;
    }
}
