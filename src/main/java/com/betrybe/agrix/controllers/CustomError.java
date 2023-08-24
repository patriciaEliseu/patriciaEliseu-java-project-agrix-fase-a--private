package com.betrybe.agrix.controllers;


/**
 * class.
 */


public class CustomError extends Exception {
  int status;

  public CustomError(String message, int status) {
    super(message);
    this.status = status;
  }

  public int getStatus() {
    return this.status;
  }
}
