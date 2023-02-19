package com.jean.flitter.dtos.requests;

import lombok.ToString;

/**
 * The NewUserRequest class represents a request to create a new user.
 *
 * This class contains the username and password for the new user. The password
 * is stored in two separate fields to confirm that the user has entered it
 * correctly.
 */
@ToString
public class NewUserRequest {

  /**
   * The username for the new user.
   */
  private String username;

  /**
   * The first password entered by the user.
   */
  private String password1;

  /**
   * The second password entered by the user to confirm it was entered
   * correctly.
   */
  private String password2;

  /**
   * Constructs a new NewUserRequest object with empty username and password
   * fields.
   */
  public NewUserRequest() {}

  /**
   * Constructs a new NewUserRequest object with the given username and password
   * fields.
   *
   * @param username the username for the new user
   * @param password1 the first password entered by the user
   * @param password2 the second password entered by the user to confirm it was
   *     entered correctly
   */
  public NewUserRequest(String username, String password1, String password2) {
    this.username = username;
    this.password1 = password1;
    this.password2 = password2;
  }

  /**
   * Returns the username for the new user.
   *
   * @return the username for the new user
   */
  public String getUsername() { return username; }

  /**
   * Sets the username for the new user.
   *
   * @param username the username for the new user
   */
  public void setUsername(String username) { this.username = username; }

  /**
   * Returns the first password entered by the user.
   *
   * @return the first password entered by the user
   */
  public String getPassword1() { return password1; }

  /**
   * Sets the first password entered by the user.
   *
   * @param password1 the first password entered by the user
   */
  public void setPassword1(String password1) { this.password1 = password1; }

  /**
   * Returns the second password entered by the user to confirm it was entered
   * correctly.
   *
   * @return the second password entered by the user to confirm it was entered
   *     correctly
   */
  public String getPassword2() { return password2; }

  /**
   * Sets the second password entered by the user to confirm it was entered
   * correctly.
   *
   * @param password2 the second password entered by the user to confirm it was
   *     entered correctly
   */
  public void setPassword2(String password2) { this.password2 = password2; }
}
