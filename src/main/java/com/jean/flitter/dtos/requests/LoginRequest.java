package com.jean.flitter.dtos.requests;

import lombok.ToString;

/**
 * A request class for user login.
 */
@ToString
public class LoginRequest {
  /**
   * The username of the user.
   */
  private String username;
  /**
   * The password of the user.
   */
  private String password;

  /**
   * Constructs an empty LoginRequest object.
   */
  public LoginRequest() {}

  /**
   * Constructs a LoginRequest object with the specified username and password.
   *
   * @param username the username of the user.
   * @param password the password of the user.
   */
  public LoginRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Returns the username of the user.
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
   * Returns the password of the user.
   *
   * @return the password of the user.
   */
  public String getPassword() { return password; }

  /**
   * Sets the password of the user.
   *
   * @param password the password of the user.
   */
  public void setPassword(String password) { this.password = password; }
}
