package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche, dependemos de pojos no de entidades
 */
@Getter
@Setter
public class CarBrandDto {

    private Integer id;
    private String description;
}
