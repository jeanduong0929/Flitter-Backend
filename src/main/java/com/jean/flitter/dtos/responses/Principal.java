package com.jean.flitter.dtos.responses;

import com.jean.flitter.entities.User;
import lombok.ToString;

@ToString
public class Principal {
  private String id;
  private String username;
  private String role;
  private String token;

  public Principal() {}
  public Principal(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.role = user.getRole().getUserRole();
  }
  public Principal(String id, String username, String role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }
  public Principal(String id, String username, String role, String token) {
    this.id = id;
    this.username = username;
    this.role = role;
    this.token = token;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public String getRole() { return role; }
  public void setRole(String role) { this.role = role; }
  public String getToken() { return token; }
  public void setToken(String token) { this.token = token; }
}
