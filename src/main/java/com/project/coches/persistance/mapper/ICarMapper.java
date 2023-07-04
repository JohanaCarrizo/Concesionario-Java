package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ICarMapper {

    CarDto toCarDto(CarEntity carEntity);
    @Mapping(target = "carBrandEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);
    List<CarDto> toCarsDto(List<CarEntity> carEntityList);
}
