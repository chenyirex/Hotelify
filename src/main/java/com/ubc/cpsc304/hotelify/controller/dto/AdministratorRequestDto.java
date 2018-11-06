package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * RequestDto for {@link com.ubc.cpsc304.hotelify.entity.Administrator}
 * Created by Rex on 2018-11-05
 */
@Data
public class AdministratorRequestDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;
}
