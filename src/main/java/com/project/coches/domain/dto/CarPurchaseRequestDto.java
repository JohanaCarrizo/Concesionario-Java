package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarPurchaseRequestDto {

    private Integer purchaseNumberBill;
    private Integer codeCar;
    private Integer quantityCars;
    private Integer total;
}
