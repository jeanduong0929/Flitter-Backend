package com.jean.flitter.dtos.requests;

import lombok.ToString;

/**
 * The NewRoleRequest class represents a request to create a new role.
 *
 * A NewRoleRequest object contains the name of the new role.
 */
@ToString
public class NewRoleRequest {

  /**
   * The name of the new role.
   */
  private String userRole;

  /**
   * Constructs an empty NewRoleRequest object.
   */
  public NewRoleRequest() {}

  /**
   * Constructs a NewRoleRequest object with the given role name.
   *
   * @param userRole the name of the new role
   */
  public NewRoleRequest(String userRole) { this.userRole = userRole; }

  /**
   * Returns the name of the new role.
   *
   * @return the name of the new role
   */
  public String getUserRole() { return userRole; }

  /**
   * Sets the name of the new role.
   *
   * @param userRole the name to set for the new role
   */
  public void setUserRole(String userRole) { this.userRole = userRole; }
}
