package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandRespository {

    List<CarBrandPojo> getAll();

    Optional<CarBrandPojo> getCarBrand(Integer id);

    CarBrandPojo save(CarBrandPojo carBrandPojo);

    void delete(Integer idCarBrand);
}
