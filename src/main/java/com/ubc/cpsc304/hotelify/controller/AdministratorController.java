package com.ubc.cpsc304.hotelify.controller;

import com.ubc.cpsc304.hotelify.controller.dto.AdministratorRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.AdministratorResponseDto;
import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationResponseDto;
import com.ubc.cpsc304.hotelify.entity.Administrator;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import com.ubc.cpsc304.hotelify.exception.UnauthorizedException;
import com.ubc.cpsc304.hotelify.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Administrator Controller
 * Created by Rex on 2018-11-05
 */
@Slf4j
@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    private static final String ADMINISTRATOR_TYPE = "admin";

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping(path = "/{username}")
    private AdministratorResponseDto getAdministrator(@PathVariable String username)
            throws NotFoundException {

        Administrator administrator = this.administratorService.getAdministrator(username);

        return AdministratorController.convertModel(administrator);
    }

    @PostMapping("/login")
    private AuthenticationResponseDto login(
            @RequestBody AuthenticationRequestDto authenticationRequestDto
    ) throws NotFoundException, UnauthorizedException {

        this.administratorService.login(authenticationRequestDto);

        return new AuthenticationResponseDto(ADMINISTRATOR_TYPE);
    }

    @PostMapping
    private AdministratorResponseDto createAdministrator(
            @RequestBody AdministratorRequestDto administratorRequestDto
    ) throws ConflictException {

        Administrator administrator = this.administratorService.createAdministrator(
                administratorRequestDto
        );

        return AdministratorController.convertModel(administrator);
    }

    @PutMapping
    private AdministratorResponseDto updateAdministrator(
            @RequestBody AdministratorRequestDto administratorRequestDto
    ) throws NotFoundException {

        Administrator administrator = this.administratorService.updateAdministrator(
                administratorRequestDto
        );

        return AdministratorController.convertModel(administrator);
    }

    @DeleteMapping(path = "/{username}")
    private void deleteAdministrator(@PathVariable String username) throws NotFoundException {
        this.administratorService.deleteAdministrator(username);
    }

    private static AdministratorResponseDto convertModel(Administrator administrator) {

        AdministratorResponseDto administratorResponseDto = new AdministratorResponseDto();

        administratorResponseDto.setUsername(administrator.getUsername());

        return administratorResponseDto;
    }
}
