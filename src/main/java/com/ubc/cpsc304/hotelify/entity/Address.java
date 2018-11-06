package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Entity class for address.
 * Created by ao on 2018-11-05
 */
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String postalCode;

    @Column
    private String nation;
}
