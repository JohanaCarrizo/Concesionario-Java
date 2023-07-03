package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarBrandDto;
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
    public List<CarBrandDto> getAll() {
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.findAll());
    }

    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.findById(id)
                .map(iCarBrandMapper::toMarcaCochePojo);
    }

    @Override
    public CarBrandDto save(CarBrandDto carBrandDto) {
        CarBrandEntity carBrandEntity = iCarBrandMapper.toMarcaCocheEntity(carBrandDto);
        return iCarBrandMapper.toMarcaCochePojo(iCarBrandCrudRepository.save(carBrandEntity));
    }

    @Override
    public void delete(Integer idCarBrand) {
        iCarBrandCrudRepository.deleteById(idCarBrand);
    }
}
