package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.domain.useCase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarService {

    private final ICarRepository iCarRepository;
    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarRepository.getCar(idCar);
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarRepository.getCarsByPriceLessThanEqualOrderByPriceAsc(price);
    }

    @Override
    public List<CarDto> getByCarBrand(Integer idCarBrand) {
        return iCarRepository.getByCarBrand(idCarBrand);
    }

    @Override
    public CarDto save(CarDto newCarDto) {
        return iCarRepository.save(newCarDto);
    }

    @Override
    public boolean delete(Integer idCar) {
        if(iCarRepository.getCar(idCar).isEmpty()){
            return false;
        }
        iCarRepository.delete(idCar);
        return true;
    }
}
