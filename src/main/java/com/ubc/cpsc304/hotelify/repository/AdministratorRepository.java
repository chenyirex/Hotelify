package com.ubc.cpsc304.hotelify.repository;

import com.ubc.cpsc304.hotelify.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Administrator}
 * Created by Rex on 2018-11-05
 */
public interface AdministratorRepository extends JpaRepository<Administrator, String> {

}
