package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link RoomType}
 * Created by Rex on 2018-11-07
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
