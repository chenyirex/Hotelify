package com.ubc.cpsc304.hotelify.entity.compositeIdClass;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoomId implements Serializable {

    @Column(name = "room_number", nullable = false, unique = true, updatable = false)
    private Long roomNumber;

    @Column(name = "hotel_id", nullable = false, unique = true, updatable = false)
    private Long hotelId;
}
