package com.jean.flitter.utils.custom_exceptions;

/**
 * The UserNotFoundException class is a custom exception that is thrown when a
 * user is not found.
 */
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String msg) { super(msg); }
}
