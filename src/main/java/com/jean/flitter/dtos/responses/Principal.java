package com.jean.flitter.dtos.responses;

import com.jean.flitter.entities.User;
import lombok.ToString;

/**
 * A class representing the authenticated user. Contains the user's ID,
 * username, role, and authentication token.
 */
@ToString
public class Principal {
  private String id;
  private String username;
  private String role;
  private String token;

  /**
   * Default constructor for the Principal class.
   */
  public Principal() {}

  /**
   * Constructor for the Principal class that takes a User object.
   *
   * @param user the User object to create the Principal from.
   */
  public Principal(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.role = user.getRole().getUserRole();
  }

  /**
   * Constructor for the Principal class that takes an ID, username, and role.
   *
   * @param id the ID of the user.
   * @param username the username of the user.
   * @param role the role of the user.
   */
  public Principal(String id, String username, String role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  /**
   * Constructor for the Principal class that takes an ID, username, role, and
   * authentication token.
   *
   * @param id the ID of the user.
   * @param username the username of the user.
   * @param role the role of the user.
   * @param token the authentication token of the user.
   */
  public Principal(String id, String username, String role, String token) {
    this.id = id;
    this.username = username;
    this.role = role;
    this.token = token;
  }

  /**
   * Gets the ID of the user.
   *
   * @return the ID of the user.
   */
  public String getId() { return id; }

  /**
   * Sets the ID of the user.
   *
   * @param id the ID of the user.
   */
  public void setId(String id) { this.id = id; }

  /**
   * Gets the username of the user.
   *
   * @return the username of the user.
   */
  public String getUsername() { return username; }

  /**
   * Sets the username of the user.
   *
   * @param username the username of the user.
   */
  public void setUsername(String username) { this.username = username; }

  /**
   * Gets the role of the user.
   *
   * @return the role of the user.
   */
  public String getRole() { return role; }

  /**
   * Sets the role of the user.
   *
   * @param role the role of the user.
   */
  public void setRole(String role) { this.role = role; }

  /**
   * Gets the authentication token of the user.
   *
   * @return the authentication token of the user.
   */
  public String getToken() { return token; }

  /**
   * Sets the authentication token of the user.
   *
   * @param token the authentication token of the user.
   */
  public void setToken(String token) { this.token = token; }
}
