package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.AddressDto;
import com.ubc.cpsc304.hotelify.entity.Address;
import com.ubc.cpsc304.hotelify.repository.AddressRepository;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 * The service layer for {@link Address}
 * Created by ao on 2018-11-05
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(AddressDto addressDto) {

        Address newAddress = new Address();

        newAddress.setStreet(addressDto.getStreet());
        newAddress.setCity(addressDto.getCity());
        newAddress.setProvince(addressDto.getProvince());
        newAddress.setPostalCode(addressDto.getPostalCode());
        newAddress.setNation(addressDto.getNation());

        return this.addressRepository.save(newAddress);
    }

    public Address changeAddress(Address address, AddressDto addressDto) {

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setProvince(addressDto.getProvince());
        address.setPostalCode(addressDto.getPostalCode());
        address.setNation(addressDto.getNation());

        return this.addressRepository.save(address);
    }

    public void deleteAddress(Address address) {
        this.addressRepository.delete(address);
    }

    // The reason for putting it here is because we do not have controller for address
    public static AddressDto convertModel(Address address) {

        if (Objects.isNull(address)) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setProvince(address.getProvince());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setNation(address.getNation());

        return addressDto;
    }
}
