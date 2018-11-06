package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
