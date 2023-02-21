package com.jean.flitter.dtos.requests;

import lombok.ToString;

/**
 * The LoginRequest class represents a login request.
 *
 * This class contains the username and password of the user attempting to log
 * in.
 */
@ToString
public class LoginRequest {
  /**
   * The username of the user attempting to log in.
   */
  private String username;

  /**
   * The password of the user attempting to log in.
   */
  private String password;

  /**
   * Creates a new LoginRequest object.
   */
  public LoginRequest() {}

  /**
   * Creates a new LoginRequest object with the given username and password.
   *
   * @param username The username of the user attempting to log in.
   * @param password The password of the user attempting to log in.
   */
  public LoginRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Returns the username of the user attempting to log in.
   *
   * @return The username of the user attempting to log in.
   */
  public String getUsername() { return username; }

  /**
   * Sets the username of the user attempting to log in.
   *
   * @param username The username of the user attempting to log in.
   */
  public void setUsername(String username) { this.username = username; }

  /**
   * Returns the password of the user attempting to log in.
   *
   * @return The password of the user attempting to log in.
   */
  public String getPassword() { return password; }

  /**
   * Sets the password of the user attempting to log in.
   *
   * @param password The password of the user attempting to log in.
   */
  public void setPassword(String password) { this.password = password; }
}
