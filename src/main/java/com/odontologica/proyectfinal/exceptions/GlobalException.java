package com.odontologica.proyectfinal.exceptions;

import com.odontologica.proyectfinal.controller.TurnoController;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    public static Logger logger = Logger.getLogger(GlobalException.class);

    // Exception Not Found
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> notFound(NotFoundException nf){
        logger.debug(nf.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
    }

    // Exception Bad Request
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequest(BadRequestException br){
        logger.debug(br.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getMessage());
    }
}
