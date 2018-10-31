package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ao on 2018-10-31
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
