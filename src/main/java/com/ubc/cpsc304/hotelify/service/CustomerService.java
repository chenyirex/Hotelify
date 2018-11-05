package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.entity.Customer;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * The Serivce layser for {@link com.ubc.cpsc304.hotelify.entity.Customer}
 * Created by ao on 2018-10-31
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerRequestDto customerRequestDto) throws ConflictException {

        String username = customerRequestDto.getUsername();

        if (this.customerRepository.findById(username).isPresent()) {
            throw new ConflictException("Username already exists");
        }

        Customer toCreateCustomer = new Customer();

        toCreateCustomer.setEmail(customerRequestDto.getEmail());
        toCreateCustomer.setFirstName(customerRequestDto.getFirstName());
        toCreateCustomer.setLastName(customerRequestDto.getLastName());
        toCreateCustomer.setPassword(customerRequestDto.getPassword());
        toCreateCustomer.setMemberPoint(0);
        toCreateCustomer.setUsername(customerRequestDto.getUsername());

        return this.customerRepository.save(toCreateCustomer);
    }
}
