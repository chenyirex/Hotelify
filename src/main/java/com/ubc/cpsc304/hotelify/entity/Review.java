package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class Review {

    @Id
    @Generated
    @Column(nullable = false, updatable = false, unique = true)
    private Long review_id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String username;

    @Column(nullable = false)
    private Long hotel_id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String comment;

    @Column(nullable = false)
    private Double rating;

}
