package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    List<CarDto> getAll();
    Optional<CarDto> getCar(Integer idCar);
    List<CarDto> getCarsByPriceLessThan(Double price);
    List<CarDto> getByCarBrand(Integer idCarBrand);
    CarDto save(CarDto newCarDto);
    boolean delete(Integer idCar);
}
