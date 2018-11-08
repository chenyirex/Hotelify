package com.ubc.cpsc304.hotelify.controller.dto;

import lombok.Data;

/**
 * Created by Rex on 2018-11-07
 */
@Data
public class RoomDto {

    private Long roomNumber;

    private boolean isAvailable;

    private Long typeId;
}
