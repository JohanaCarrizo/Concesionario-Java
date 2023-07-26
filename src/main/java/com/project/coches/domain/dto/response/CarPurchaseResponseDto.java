package com.project.coches.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarPurchaseResponseDto {

    private String referenceCar;
    private Integer quantityCars;
    private Integer total;
}
