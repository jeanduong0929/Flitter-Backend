package com.jean.flitter.utils.custom_exceptions;

public class CannotCreateUserException extends RuntimeException {
  public CannotCreateUserException(String msg) { super(msg); }
}
