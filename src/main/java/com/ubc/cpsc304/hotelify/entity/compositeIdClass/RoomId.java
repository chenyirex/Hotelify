package com.ubc.cpsc304.hotelify.entity.compositeIdClass;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class RoomId implements Serializable {

    private Long roomNumber;

    private Long hotelId;
}
