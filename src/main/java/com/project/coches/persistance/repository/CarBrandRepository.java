package com.project.coches.persistance.repository;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRespository;
import com.project.coches.persistance.entity.CarBrandEntity;
import com.project.coches.persistance.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarBrandRepository implements ICarBrandRespository {

    private final ICarBrandCrudRepository iCarBrandCrudRepository;
    private final ICarBrandMapper iCarBrandMapper;


    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.findAll());
    }

    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id)
                .map(iCarBrandMapper::toMarcaCochePojo);
    }

    @Override
    public CarBrandPojo save(CarBrandPojo carBrandPojo) {
        CarBrandEntity carBrandEntity = iCarBrandMapper.toMarcaCocheEntity(carBrandPojo);
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.save(carBrandEntity));
    }

    @Override
    public void delete(Integer idCarBrand) {
        iCarBrandCrudRepository.deleteById(idCarBrand);
    }
}
