package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.HotelRequestDto;
import com.ubc.cpsc304.hotelify.entity.Hotel;
import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.repository.HotelRepository;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Service layer for com.ubc.cpsc304.hotelify.entity.Hotel
 * Scott 2018-11-05
 */

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(HotelRequestDto requestDto) throws BadRequestException {
        String brandName = requestDto.getBrandName();
        Long addressId = requestDto.getAddressId();

        if (brandName == null || addressId == null) {
            throw new BadRequestException("brandName and addressId cannot be null");
        }

        Hotel hotelToInsert = new Hotel();
        hotelToInsert.setBrandName(requestDto.getBrandName());
        hotelToInsert.setBranchName(requestDto.getBranchName());
        hotelToInsert.setPropertyClass(requestDto.getPropertyClass());
        hotelToInsert.setAddressId(requestDto.getAddressId());
        hotelToInsert.setDescription(requestDto.getDescription());
        hotelToInsert.setOverallRating(requestDto.getOverallRating());

        return this.hotelRepository.save(hotelToInsert);
    }

    public Hotel updateHotelById(HotelRequestDto requestDto) throws BadRequestException {
        Long id = requestDto.getId();
        if (id == null) {
            throw new BadRequestException("Id cannot be null");
        }

        // handle EntityNotFoundException
        Hotel hotelToUpdate = this.hotelRepository.getOne(id);

        hotelToUpdate.setBrandName(requestDto.getBrandName());
        hotelToUpdate.setBranchName(requestDto.getBranchName());
        hotelToUpdate.setPropertyClass(requestDto.getPropertyClass());
        hotelToUpdate.setAddressId(requestDto.getAddressId());
        hotelToUpdate.setDescription(requestDto.getDescription());
        hotelToUpdate.setOverallRating(requestDto.getOverallRating());

        return this.hotelRepository.save(hotelToUpdate);
    }

    public Long deleteHotelById(HotelRequestDto requestDto) throws BadRequestException {
        Long id = requestDto.getId();
        if (id == null) {
            throw new BadRequestException("Id cannot be null");
        }

        this.hotelRepository.deleteById(id);
        return id;

    }


}
