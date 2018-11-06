package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.AdministratorRequestDto;
import com.ubc.cpsc304.hotelify.controller.dto.AuthenticationRequestDto;
import com.ubc.cpsc304.hotelify.entity.Administrator;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import com.ubc.cpsc304.hotelify.exception.UnauthorizedException;
import com.ubc.cpsc304.hotelify.repository.AdministratorRepository;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer for {@link Administrator}
 * Created by Rex on 2018-11-05
 */
@Slf4j
@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Administrator findByUsername(String username)
            throws NotFoundException {

        Administrator administrator = this.administratorRepository.findById(username).orElse(null);

        if (Objects.isNull(administrator)) {
            throw new NotFoundException("Requested Admin does not exist");
        }

        return administrator;
    }

    public void login(AuthenticationRequestDto authenticationRequestDto)
            throws NotFoundException, UnauthorizedException {
        Administrator administrator = this.findByUsername(authenticationRequestDto.getUsername());

        if (!authenticationRequestDto.getPassword().equals(administrator.getPassword())) {
            throw new UnauthorizedException("Password mismatch");
        }
    }

    public Administrator createAdministrator(AdministratorRequestDto administratorRequestDto)
            throws ConflictException {

        String username = administratorRequestDto.getUsername();

        if (this.administratorRepository.findById(username).isPresent()) {
            throw new ConflictException("Username already exists");
        }
        Administrator administrator = new Administrator();

        administrator.setUsername(administratorRequestDto.getUsername());
        administrator.setFirstName(administratorRequestDto.getFirstName());
        administrator.setLastName(administratorRequestDto.getLastName());
        administrator.setPassword(administratorRequestDto.getPassword());

        return this.administratorRepository.save(administrator);
    }

    public Administrator updateAdministrator(Administrator administrator) {

        return this.administratorRepository.save(administrator);
    }

    public void deleteAdministrator(Administrator administrator) {

        this.administratorRepository.delete(administrator);
    }
}
