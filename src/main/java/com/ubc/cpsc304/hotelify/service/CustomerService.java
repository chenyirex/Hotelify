package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.entity.Customer;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import com.ubc.cpsc304.hotelify.exception.UnauthorizedException;
import com.ubc.cpsc304.hotelify.repository.CustomerRepository;
import java.util.Objects;
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

    public Customer getCustomer(String username) throws NotFoundException {

        Customer customer = this.customerRepository.findById(username).orElse(null);

        if (Objects.isNull(customer)) {
            throw new NotFoundException("Requested Customer does not exist");
        }

        return customer;
    }

    public void login(AuthenticationRequestDto authenticationRequestDto)
            throws NotFoundException, UnauthorizedException {

        Customer customer = this.getCustomer(authenticationRequestDto.getUsername());

        if (!authenticationRequestDto.getPassword().equals(customer.getPassword())) {
            throw new UnauthorizedException("Password mismatch");
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
}
