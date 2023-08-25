package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * class.
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(CustomError.class)
  public ResponseEntity<String> handleException(CustomError error) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDto> handleException(Exception error) {
    ResponseDto responseDto = new ResponseDto(null, error.getMessage());
    return ResponseEntity.status(500).body(responseDto);
  }
}
