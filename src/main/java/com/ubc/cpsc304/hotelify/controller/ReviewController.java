package com.ubc.cpsc304.hotelify.controller;


import com.ubc.cpsc304.hotelify.controller.dto.ReviewRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.ReviewResponseDto;
import com.ubc.cpsc304.hotelify.entity.Review;
import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    private String getReview() {
        return "Hello world";
    }

    @PostMapping
    private ReviewResponseDto createReview(@RequestBody ReviewRequestDto reviewRequestDto) throws BadRequestException{

        if (Objects.isNull(reviewRequestDto.getHotel_id())) {
            throw new BadRequestException("brandName and addressId cannot be null");
        }

        Review createdReview = this.reviewService.createReview(reviewRequestDto);

        return ReviewController.convertModel(createdReview);
    }

    private static ReviewResponseDto convertModel(Review review) {

        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();

        reviewResponseDto.setReview_id(review.getReview_id());

        return reviewResponseDto;
    }

}
