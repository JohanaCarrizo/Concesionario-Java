package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;

public interface ICarBrandRespository {

    List<CarBrandDto> getAll();

    Optional<CarBrandDto> getCarBrand(Integer id);

    CarBrandDto save(CarBrandDto carBrandDto);

    void delete(Integer idCarBrand);
}
