package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * The Response Dto For {@link com.ubc.cpsc304.hotelify.entity.Customer}
 * Created by ao on 2018-10-31
 */
@Data
public class CustomerResponseDto {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private AddressDto address;
}
