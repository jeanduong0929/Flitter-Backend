package com.jean.flitter.utils.custom_exceptions;

/**
 * Exception thrown when a user cannot be created due to an error.
 */
public class CannotCreateUserException extends RuntimeException {

  /**
   * Constructs a new {@code CannotCreateUserException} with the specified
   * detail message.
   *
   * @param msg the detail message
   */
  public CannotCreateUserException(String msg) { super(msg); }
}
