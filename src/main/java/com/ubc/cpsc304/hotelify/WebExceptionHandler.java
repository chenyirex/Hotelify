package com.ubc.cpsc304.hotelify;

import com.ubc.cpsc304.hotelify.exception.BadRequestException;
import com.ubc.cpsc304.hotelify.exception.ConflictException;
import com.ubc.cpsc304.hotelify.exception.NotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Controller Advice for all the controllers.
 * Created by ao on 2018-11-04
 */
@ControllerAdvice
@EnableWebMvc
public class WebExceptionHandler {

    private static final String BAD_REQUEST = "400";
    private static final String NOT_FOUND_CODE = "404";
    private static final String CONFLICT = "409";
    private static final String INTERNAL_ERROR_CODE = "500";

    private static final String CODE = "code";
    private static final String MESSAGE = "error";

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> handleNotFound(Exception e) {

        Map<String, String> response = new HashMap<>();

        response.put(CODE, NOT_FOUND_CODE);
        response.put(MESSAGE, e.getMessage());

        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, String> handleBadRequest(Exception e) {

        Map<String, String> response = new HashMap<>();

        response.put(CODE, BAD_REQUEST);
        response.put(MESSAGE, e.getMessage());

        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public Map<String, String> handleConflict(Exception e) {

        Map<String, String> response = new HashMap<>();

        response.put(CODE, CONFLICT);
        response.put(MESSAGE, e.getMessage());

        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalError.class)
    public Map<String, String> handleInternalError(Exception e) {

        Map<String, String> response = new HashMap<>();

        response.put(CODE, INTERNAL_ERROR_CODE);
        response.put(MESSAGE, e.getMessage());

        return response;
    }
}
