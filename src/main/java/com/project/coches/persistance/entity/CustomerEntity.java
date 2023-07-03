package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private String cardId;

    @NotBlank
    @Column(name = "nombre_completo")
    private String fullName;

    @Email
    @NotBlank
    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    @NotBlank
    private String numberCellPhone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;
}
