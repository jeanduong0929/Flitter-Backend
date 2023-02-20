package com.jean.flitter.utils.custom_exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() { super("Invalid username or password"); }
}
