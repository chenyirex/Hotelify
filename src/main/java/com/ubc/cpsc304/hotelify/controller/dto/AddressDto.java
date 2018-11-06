package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * The response and request Dto is the same for address.
 * Created by ao on 2018-11-05
 */
@Data
public class AddressDto {

    private String street;

    private String city;

    private String province;

    private String postalCode;

    private String nation;
}
