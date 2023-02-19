package com.jean.flitter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jean.flitter.dtos.requests.NewUserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.ToString;

/**
 * The User class represents a user of the system.
 *
 * This class contains the user's ID, username, hashed password, salt, and
 * associated role. The password and salt are stored as byte arrays.
 */
@Entity
@ToString
@Table(name = "fl_user")
public class User {
  /**
   * The unique ID of the user.
   */
  @Id private String id;

  /**
   * The username of the user.
   */
  @Column(name = "username", nullable = false) private String username;

  /**
   * The hashed password of the user.
   */
  @Column(name = "password", nullable = false) private byte[] password;

  /**
   * The salt used to hash the user's password.
   */
  @Column(name = "salt", nullable = false) private byte[] salt;

  /**
   * The role associated with the user.
   */
  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
  @JsonBackReference
  private Role role;

  /**
   * Constructs a new User object with empty fields.
   */
  public User() {}

  /**
   * Constructs a new User object with the given fields.
   *
   * @param req the request containing the username and password for the new
   *     user
   * @param password the hashed password for the new user
   * @param salt the salt used to hash the new user's password
   * @param role the role associated with the new user
   */
  public User(NewUserRequest req, byte[] password, byte[] salt, Role role) {
    this.id = UUID.randomUUID().toString();
    this.username = req.getUsername();
    this.password = password;
    this.salt = salt;
    this.role = role;
  }

  /**
   * Constructs a new User object with the given fields.
   *
   * @param id the unique ID of the user
   * @param username the username of the user
   * @param password the hashed password of the user
   * @param salt the salt used to hash the user's password
   * @param role the role associated with the user
   */
  public User(String id, String username, byte[] password, byte[] salt,
              Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.role = role;
  }

  /**
   * Returns the unique ID of the user.
   *
   * @return the unique ID of the user
   */
  public String getId() { return id; }

  /**
   * Sets the unique ID of the user.
   *
   * @param id the unique ID of the user
   */
  public void setId(String id) { this.id = id; }

  /**
   * Returns the username of the user.
   *
   * @return the username of the user
   */
  public String getUsername() { return username; }

  /**
   * Sets the username of the user.
   *
   * @param username the username of the user
   */
  public void setUsername(String username) { this.username = username; }

  /**
   * Returns the hashed password of the user.
   *
   * @return the hashed password of the user
   */
  public byte[] getPassword() { return password; }

  /**
   * Sets the hashed password of the user.
   *
   * @param password the hashed password of the user
   */
  public void setPassword(byte[] password) { this.password = password; }

  /**
   * Returns the salt value used to hash the user's password.
   *
   * @return the salt value
   */
  public byte[] getSalt() { return salt; }

  /**
   * Sets the salt value used to hash the user's password.
   *
   * @param salt the salt value to set
   */
  public void setSalt(byte[] salt) { this.salt = salt; }

  /**
   * Returns the role associated with the user.
   *
   * @return the user's role
   */
  public Role getRole() { return role; }

  /**
   * Sets the role associated with the user.
   *
   * @param role the role to set
   */
  public void setRole(Role role) { this.role = role; }
}
