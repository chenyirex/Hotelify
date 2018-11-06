package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * RequestDto for authentication purposes
 * Created by Rex on 2018-11-05
 */
@Data
public class AuthenticationRequestDto {

    private String username;

    private String password;
}
