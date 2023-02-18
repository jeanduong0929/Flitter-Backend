package com.jean.flitter.utils.custom_exceptions;

/**
 * The RoleNotFoundException is thrown when a requested role is not found in the
 * database.
 */
public class RoleNotFoundException extends RuntimeException {

  /**
   * Constructs a new RoleNotFoundException with the specified role name.
   *
   * @param userRole the name of the role that was not found
   */
  public RoleNotFoundException(String userRole) {
    super("Could not found role with role: " + userRole);
  }
}
