package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * class.
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(CustomError.class)
  public ResponseEntity<ResponseDto> handleException(CustomError error) {
    ResponseDto responseDto = new ResponseDto<>(null, error.getMessage());
    return ResponseEntity.status(error.getStatus()).body(responseDto);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDto> handleException(Exception error) {
    ResponseDto responseDto = new ResponseDto(null, error.getMessage());
    return ResponseEntity.status(500).body(responseDto);
  }
}
