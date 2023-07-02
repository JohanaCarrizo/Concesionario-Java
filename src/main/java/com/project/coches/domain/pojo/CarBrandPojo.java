package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche, dependemos de pojos no de entidades
 */
@Getter
@Setter
public class CarBrandPojo {

    private Integer id;
    private String description;
}
