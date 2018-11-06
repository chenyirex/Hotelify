package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
