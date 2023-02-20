package com.jean.flitter.utils.custom_exceptions;

/**
 * Exception that indicates that the provided username and/or password is
 * invalid and a user could not be found.
 */
public class UserNotFoundException extends RuntimeException {
  /**
   * Constructs a new {@code UserNotFoundException} with the default detail
   * message "Invalid username or password".
   */
  public UserNotFoundException() { super("Invalid username or password"); }
}
