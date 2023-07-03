package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarDto {

    private Integer carId;
    private Integer carBrandId;
    private String reference;
    private Double price;
    private Integer modelYear;
    private String color;
    private Double horsepower;
    private Integer numberDoor;
    private Double enginerDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private Integer traction;
    private String steering;
    private String category;
    private String imagePath;

}
