package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Room;
import com.ubc.cpsc304.hotelify.entity.compositeIdClass.RoomId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Room}
 * Created by Rex on 2018-11-07
 */
public interface RoomRepository extends JpaRepository<Room, RoomId> {

    List<Room> findByHotelId(Long hotelId);
}
