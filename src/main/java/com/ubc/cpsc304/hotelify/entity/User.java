package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * Super class for admins and customers
 * Created by Rex on 2018-11-05
 */
@Data
@MappedSuperclass
public class User {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String password;
}
