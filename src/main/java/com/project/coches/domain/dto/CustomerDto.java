package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerDto {

    private String cardId;
    private String fullName;
    private String email;
    private String numberCellPhone;
    private Integer active;
    private String password;
    private String rol;
}
