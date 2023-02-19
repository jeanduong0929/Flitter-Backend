package com.jean.flitter.utils.custom_exceptions;

/**
 * Exception thrown when an authentication request is invalid.
 */
public class InvalidAuthException extends RuntimeException {

  /**
   * Constructs a new {@code InvalidAuthException} with the specified detail
   * message.
   *
   * @param msg the detail message
   */
  public InvalidAuthException(String msg) { super(msg); }
}
