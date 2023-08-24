package com.betrybe.agrix.controllers.dto;

/**
 * record.
 */


public record ResponseDto<T>(String message, T data) {
}
