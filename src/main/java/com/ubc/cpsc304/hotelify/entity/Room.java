package com.ubc.cpsc304.hotelify.entity;

import com.ubc.cpsc304.hotelify.entity.compositeIdClass.RoomId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * Entity room
 * Created by Rex on 2018-11-07
 */
@Data
@Entity
@IdClass(RoomId.class)
public class Room {

    @Id
    private Long roomNumber;

    @Id
    private Long hotelId;

//    @ManyToOne
//    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
//    private Hotel hotel;

    @Column(nullable = false)
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "roomtype_id", referencedColumnName = "id")
    private RoomType type;
}

