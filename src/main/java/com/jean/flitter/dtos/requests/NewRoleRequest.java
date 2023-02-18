package com.jean.flitter.dtos.requests;

import lombok.ToString;

@ToString
public class NewRoleRequest {
  private String userRole;

  public NewRoleRequest() {}
  public NewRoleRequest(String userRole) { this.userRole = userRole; }

  public String getUserRole() { return userRole; }
  public void setUserRole(String userRole) { this.userRole = userRole; }
}
