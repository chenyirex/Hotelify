package com.ubc.cpsc304.hotelify.controller;

import com.ubc.cpsc304.hotelify.controller.dto.HotelRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.HotelResponseDto;
import com.ubc.cpsc304.hotelify.entity.Hotel;
import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    private String getHotel() {
        return "Hello from hotels";
    }

    @PostMapping
    private HotelResponseDto createHotel(@RequestBody HotelRequestDto requestDto) throws BadRequestException {
        HotelResponseDto responseDto = new HotelResponseDto();
        Hotel hotel = this.hotelService.createHotel(requestDto);
        // TODO: what to return??
        responseDto.setMessage("create success");

        return responseDto;
    }

    @PutMapping
    private HotelResponseDto updateHotel(@RequestBody HotelRequestDto requestDto) throws BadRequestException{
        HotelResponseDto responseDto = new HotelResponseDto();
        Hotel hotel = this.hotelService.updateHotelById(requestDto);
        // TODO: what to return??
        responseDto.setMessage("update success");

        return responseDto;
    }
//
    @DeleteMapping
    private HotelResponseDto deleteHotel(@RequestBody HotelRequestDto requestDto)throws BadRequestException{
        HotelResponseDto responseDto = new HotelResponseDto();
        Long id = this.hotelService.deleteHotelById(requestDto);
        // TODO: what to return??
        responseDto.setMessage("deleted " + id);

        return responseDto;
    }

}
