package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

    List<CarBrandPojo> getAll();

    Optional<CarBrandPojo> getCarBrand(Integer id);

    CarBrandPojo save(CarBrandPojo carBrandPojo);

    Optional<CarBrandPojo> update(CarBrandPojo carBrandPojo);

    boolean delete(Integer idCarBrand);
}
