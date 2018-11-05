package com.ubc.cpsc304.hotelify.controller;

import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.CustomerResponseDto;
import com.ubc.cpsc304.hotelify.entity.Customer;
import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.service.CustomerService;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ao on 2018-10-31
 */
@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    private String getCustomer() {
        return "Hello world";
    }

    @PostMapping
    private CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto)
            throws BadRequestException, ConflictException {

        if (Objects.isNull(customerRequestDto.getUsername()) ||
                Objects.isNull(customerRequestDto.getPassword())) {
            throw new BadRequestException("Either username or password is not provided");
        }

        Customer createdCustomer = this.customerService.createCustomer(customerRequestDto);

        return CustomerController.convertModel(createdCustomer);
    }

    private static CustomerResponseDto convertModel(Customer customer) {

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setUsername(customer.getUsername());

        return customerResponseDto;
    }
}
