package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

@Data
public class ReviewRequestDto {
    private Long review_id;

    private String username;

    private Long hotel_id;

    private String comment;

    private Double rating;

}
