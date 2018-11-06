package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * ResponseDto for {@link com.ubc.cpsc304.hotelify.entity.Administrator}
 * Created by Rex on 2018-11-05
 */
@Data
public class AdministratorResponseDto {

    private String username;

    private String firstName;

    private String lastName;
}
