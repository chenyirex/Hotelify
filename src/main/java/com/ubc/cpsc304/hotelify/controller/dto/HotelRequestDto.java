package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

@Data
public class HotelRequestDto {

    private Long id;

    private String brandName;

    private String branchName;

    private int propertyClass;

    private Long addressId;

    private String description;

    private String overallRating;
}
