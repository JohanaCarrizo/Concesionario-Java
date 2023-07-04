package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {

    List<CarDto> getAll();
    Optional<CarDto> getCar(Integer idCar);
    List<CarDto> getCarsByPriceLessThanEqualOrderByPriceAsc(Double price);
    List<CarDto> getByCarBrand(Integer idCarBrand);
    CarDto save(CarDto newCarDto);
    void delete(Integer idCar);
}
