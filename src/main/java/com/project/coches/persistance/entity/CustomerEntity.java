package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private String cardId;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private String numberCellPhone;

    @Column(name = "activo")
    private  Integer active;

    @Column(name = "contrasenia")
    private String password;
}
