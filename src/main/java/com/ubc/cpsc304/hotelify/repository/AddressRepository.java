package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Repository for {@link Address}
 * Created by ao on 2018-11-05
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
