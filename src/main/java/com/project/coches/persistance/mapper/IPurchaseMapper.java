package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {ICarPurchaseMapper.class})
@Component
public interface IPurchaseMapper {
    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);
}
