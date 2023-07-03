package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.repository.ICarBrandRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarBrandServiceImpl implements ICarBrandService{

    private final ICarBrandRespository iCarBrandRespository;
    @Override
    public List<CarBrandDto> getAll() {
        return iCarBrandRespository.getAll();
    }

    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandRespository.getCarBrand(id);
    }

    @Override
    public CarBrandDto save(CarBrandDto carBrandDto) {
        return iCarBrandRespository.save(carBrandDto);
    }

    @Override
    public Optional<CarBrandDto> update(CarBrandDto carBrandDto) {
        if(iCarBrandRespository.getCarBrand(carBrandDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCarBrandRespository.save(carBrandDto));
    }

    @Override
    public boolean delete(Integer idCarBrand) {

        if(iCarBrandRespository.getCarBrand(idCarBrand).isEmpty()){
            return false;
        }
        iCarBrandRespository.delete(idCarBrand);
        return true;
    }
}
