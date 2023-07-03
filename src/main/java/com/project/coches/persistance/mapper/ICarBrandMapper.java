package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.persistance.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper que transforma objetos de MarcaCoche a Pojos o Entidades
 */
@Mapper(componentModel = "spring")
@Component
public interface ICarBrandMapper {

    /**
     * Convierte una entidad a un pojo de marca coche
     * @param carBrandEntity
     * @return
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandDto toMarcaCochePojo(CarBrandEntity carBrandEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param carBrandDto
     * @return
     */
    @InheritInverseConfiguration
    CarBrandEntity toMarcaCocheEntity(CarBrandDto carBrandDto);

    /**
     * Retorna una lista de marca coches transformada a pojo de una lista de entidades
     * @param marcasCochesEntity
     * @return
     */
    List<CarBrandDto> toMarcaCochePojo(List<CarBrandEntity> marcasCochesEntity);
}
