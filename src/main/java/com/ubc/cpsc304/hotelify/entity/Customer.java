package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The entity class for customer.
 * Created by ao on 2018-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Customer extends User {

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String email;

    @Column
    private int memberPoint;

    // Foreign Key Attributes:
    // coupon, reservation, address, review
    // Add those fields later
}
