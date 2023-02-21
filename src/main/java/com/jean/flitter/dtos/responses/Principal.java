package com.jean.flitter.dtos.responses;

import com.jean.flitter.entities.User;
import lombok.ToString;

/**
 * The Principal class represents a user's principal.
 *
 * This class contains the user's ID, username, and role.
 */
@ToString
public class Principal {
  /**
   * The unique ID of the user.
   */
  private String id;

  /**
   * The username of the user.
   */
  private String username;

  /**
   * The role of the user.
   */
  private String role;

  /**
   * The token of the user.
   */
  private String token;

  /**
   * Creates a new Principal object.
   */
  public Principal() {}

  /**
   * Creates a new Principal object.
   *
   * @param user The user associated with the principal.
   */
  public Principal(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.role = user.getRole().getUserRole();
  }

  /**
   * Creates a new Principal object.
   *
   * @param id The ID of the user.
   * @param username The username of the user.
   * @param role The role of the user.
   */
  public Principal(String id, String username, String role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  /**
   * Creates a new Principal object.
   *
   * @param id The ID of the user.
   * @param username The username of the user.
   * @param role The role of the user.
   * @param token The token of the user.
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
   * @return The ID of the user.
   */
  public String getId() { return id; }

  /**
   * Sets the ID of the user.
   *
   * @param id The ID of the user.
   */
  public void setId(String id) { this.id = id; }

  /**
   * Gets the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() { return username; }

  /**
   * Sets the username of the user.
   *
   * @param username The username of the user.
   */
  public void setUsername(String username) { this.username = username; }

  /**
   * Gets the role of the user.
   *
   * @return The role of the user.
   */
  public String getRole() { return role; }

  /**
   * Sets the role of the user.
   *
   * @param role The role of the user.
   */
  public void setRole(String role) { this.role = role; }

  /**
   * Gets the token of the user.
   *
   * @return The token of the user.
   */
  public String getToken() { return token; }

  /**
   * Sets the token of the user.
   *
   * @param token The token of the user.
   */
  public void setToken(String token) { this.token = token; }
}
