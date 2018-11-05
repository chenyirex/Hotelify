package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * The entity class for customer.
 * Created by ao on 2018-10-31
 */
@Data
@Entity
public class Customer {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email;

    @Column
    private int memberPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    // Foreign Key Attributes:
    // coupon, reservation, review
    // Add those fields later
}
