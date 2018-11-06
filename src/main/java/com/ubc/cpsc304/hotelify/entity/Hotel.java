package com.ubc.cpsc304.hotelify.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * The entity class for hotel.
 * Created by Scott on 2018-11-5
 */

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(30) DEFAULT ''")
    private String brandName;

    @Column(columnDefinition = "VARCHAR(30) DEFAULT ''")
    private String branchName;

    @Column
    private int propertyClass;

    @Column(nullable = false)
    private Long addressId;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String description;

    @Column(columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String overallRating;

    //FOREIGN KEY (address_id) REFERENCES address
}
