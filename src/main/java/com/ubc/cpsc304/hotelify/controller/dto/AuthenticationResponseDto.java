package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ResponseDto for authentication purposes
 * Created by Rex on 2018-11-05
 */
@Data
@AllArgsConstructor
public class AuthenticationResponseDto {

    private String userType;
}
