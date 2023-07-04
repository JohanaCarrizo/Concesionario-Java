package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarBrandDto;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

    List<CarBrandDto> getAll();

    Optional<CarBrandDto> getCarBrand(Integer id);

    CarBrandDto save(CarBrandDto carBrandDto);

    Optional<CarBrandDto> update(CarBrandDto carBrandDto);

    boolean delete(Integer idCarBrand);
}
