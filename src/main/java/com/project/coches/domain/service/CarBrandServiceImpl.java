package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;
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
    public List<CarBrandPojo> getAll() {
        return iCarBrandRespository.getAll();
    }

    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandRespository.getCarBrand(id);
    }

    @Override
    public CarBrandPojo save(CarBrandPojo carBrandPojo) {
        return iCarBrandRespository.save(carBrandPojo);
    }

    @Override
    public boolean delete(Integer idCarBrand) {
        try{
            iCarBrandRespository.delete(idCarBrand);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
