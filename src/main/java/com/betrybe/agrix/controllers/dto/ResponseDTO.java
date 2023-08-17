package com.betrybe.agrix.controllers.dto;

/**
 * record.
 */


public record ResponseDTO<T>(String message, T data) {
}
