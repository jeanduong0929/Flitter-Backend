package com.jean.flitter.utils.custom_exceptions;

public class RoleNotFoundException extends RuntimeException {
  public RoleNotFoundException(String userRole) {
    super("Could not found role with role: " + userRole);
  }
}
