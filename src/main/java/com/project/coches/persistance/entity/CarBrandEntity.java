package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de Marca Coche
 */
@Getter
@Setter
@Entity
@Table(name = "marca_coche")
public class CarBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    @NotBlank
    private String description;
}
