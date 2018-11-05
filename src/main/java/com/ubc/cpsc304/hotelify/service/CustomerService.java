package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.entity.Address;
import com.ubc.cpsc304.hotelify.entity.Customer;
import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The service layer for {@link com.ubc.cpsc304.hotelify.entity.Customer}
 * Created by ao on 2018-10-31
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByUsername(String username) throws BadRequestException {

        Optional<Customer> optionalCustomer = this.customerRepository.findById(username);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new BadRequestException("username does not exist");
        }
    }

    public Customer createCustomer(CustomerRequestDto customerRequestDto) throws ConflictException {

        String username = customerRequestDto.getUsername();

        if (this.customerRepository.findById(username).isPresent()) {
            throw new ConflictException("Username already exists");
        }

        Customer newCustomer = new Customer();

        newCustomer.setEmail(customerRequestDto.getEmail());
        newCustomer.setFirstName(customerRequestDto.getFirstName());
        newCustomer.setLastName(customerRequestDto.getLastName());
        newCustomer.setPassword(customerRequestDto.getPassword());
        newCustomer.setMemberPoint(0);
        newCustomer.setUsername(customerRequestDto.getUsername());

        return this.customerRepository.save(newCustomer);
    }

    public Customer saveAddress(Customer customer, Address address) {

        customer.setAddress(address);

        return this.customerRepository.save(customer);
    }
}
