package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * Request DTO for {@link com.ubc.cpsc304.hotelify.entity.Customer}
 * Created by ao on 2018-10-31
 */
@Data
public class CustomerRequestDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
}
