package com.jean.flitter.utils.custom_exceptions;

public class InvalidAuthException extends RuntimeException {
  public InvalidAuthException(String msg) { super(msg); }
}
