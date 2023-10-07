package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.AuthCustomerDto;
import com.project.coches.domain.dto.response.JwtResponseDto;

public interface IAuthService {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
