package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * The Serivce layser for {@link com.ubc.cpsc304.hotelify.entity.Customer}
 * Created by ao on 2018-10-31
 */
@Service
public class CustomerService {

    private final CustomerService customerService;

    public CustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer createCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }
}
