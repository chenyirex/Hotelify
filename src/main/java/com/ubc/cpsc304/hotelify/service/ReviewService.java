package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.ReviewRequestDto;
import com.ubc.cpsc304.hotelify.entity.Review;
import com.ubc.cpsc304.hotelify.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    public Review createReview(ReviewRequestDto reviewRequestDto){
        Long review_id = reviewRequestDto.getReview_id();

        Review toCreateReview = new Review();

        toCreateReview.setReview_id(reviewRequestDto.getReview_id());
        toCreateReview.setUsername(reviewRequestDto.getUsername());
        toCreateReview.setHotel_id(reviewRequestDto.getHotel_id());
        toCreateReview.setComment(reviewRequestDto.getComment());
        toCreateReview.setRating(reviewRequestDto.getRating());

        return this.reviewRepository.save(toCreateReview);
    }

}
