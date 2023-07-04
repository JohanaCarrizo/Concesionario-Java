package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistance.crud.ICarCrudRepository;
import com.project.coches.persistance.entity.CarEntity;
import com.project.coches.persistance.entity.CustomerEntity;
import com.project.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;
    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarCrudRepository.findById(idCar)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByPriceLessThan(price));
    }

    @Override
    public List<CarDto> getByCarBrand(Integer idCarBrand) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByCarBrandId(idCarBrand));
    }

    @Override
    public CarDto save(CarDto newCarDto) {
        CarEntity carEntity = iCarMapper.toCarEntity(newCarDto);
        return iCarMapper.toCarDto(iCarCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Integer idCar) {
        iCarCrudRepository.deleteById(idCar);
    }
}
