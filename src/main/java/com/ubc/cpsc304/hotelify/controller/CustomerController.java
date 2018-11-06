package com.ubc.cpsc304.hotelify.controller;

import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationResponseDto;
import com.ubc.cpsc304.hotelify.controller.dto.AddressDto;
import com.ubc.cpsc304.hotelify.controller.dto.CustomerRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.CustomerResponseDto;
import com.ubc.cpsc304.hotelify.entity.Address;
import com.ubc.cpsc304.hotelify.entity.Customer;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import com.ubc.cpsc304.hotelify.exception.UnauthorizedException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import com.ubc.cpsc304.hotelify.service.AddressService;
import com.ubc.cpsc304.hotelify.service.CustomerService;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    private static final String CUSTOMER_TYPE = "customer";

    private final CustomerService customerService;
    private final AddressService addressService;

    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @GetMapping
    private String getCustomer() {
        return "Hello world";
    }

    @PostMapping("/login")
    private AuthenticationResponseDto login(
            @RequestBody AuthenticationRequestDto authenticationRequestDto
    ) throws NotFoundException, UnauthorizedException {

        this.customerService.login(authenticationRequestDto);

        return new AuthenticationResponseDto(CUSTOMER_TYPE);
    }

    @PostMapping
    private CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto)
            throws ConflictException {

        Customer createdCustomer = this.customerService.createCustomer(customerRequestDto);

        return CustomerController.convertModel(createdCustomer);
    }

    @GetMapping("/{username}")
    private CustomerResponseDto getCustomer(@PathVariable String username)
            throws NotFoundException {

        Customer customer = this.customerService.findByUsername(username);

        return CustomerController.convertModel(customer);
    }

    @PostMapping("/{username}/address")
    private AddressDto addAddressInformationToCustomer(
            @PathVariable String username,
            @RequestBody AddressDto addressDto
    ) throws ConflictException, NotFoundException {

        Customer customer = this.customerService.findByUsername(username);

        if (Objects.nonNull(customer.getAddress())) {
            throw new ConflictException("Customer already has an address, use PUT for change");
        }

        Address address = this.addressService.addAddress(addressDto);

        this.customerService.saveAddress(customer, address);

        return AddressService.convertModel(address);
    }

    @PutMapping("/{username}/address")
    private AddressDto modifyAddressInformationInCustomer(
            @PathVariable String username,
            @RequestBody AddressDto addressDto
    ) throws NotFoundException, ConflictException {

        Customer customer = this.customerService.findByUsername(username);

        if (Objects.nonNull(customer.getAddress())) {
            throw new ConflictException("Customer does not have an address, use POST");
        }

        Address address = this.addressService.changeAddress(customer.getAddress(), addressDto);

        this.customerService.saveAddress(customer, address);

        return AddressService.convertModel(address);
    }

    private static CustomerResponseDto convertModel(Customer customer) {

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setUsername(customer.getUsername());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setFirstName(customer.getFirstName());
        customerResponseDto.setLastName(customer.getLastName());
        customerResponseDto.setAddress(AddressService.convertModel(customer.getAddress()));

        return customerResponseDto;
    }
}
