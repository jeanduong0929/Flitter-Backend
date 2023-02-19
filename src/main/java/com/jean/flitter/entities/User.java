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

@Entity
@ToString
@Table(name = "fl_user")
public class User {
  @Id private String id;
  @Column(name = "username", nullable = false) private String username;
  @Column(name = "password", nullable = false) private byte[] password;
  @Column(name = "salt", nullable = false) private byte[] salt;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
  @JsonBackReference
  private Role role;

  public User() {}
  public User(NewUserRequest req, byte[] password, byte[] salt, Role role) {
    this.id = UUID.randomUUID().toString();
    this.username = req.getUsername();
    this.password = password;
    this.salt = salt;
    this.role = role;
  }
  public User(String id, String username, byte[] password, byte[] salt,
              Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.role = role;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public byte[] getPassword() { return password; }
  public void setPassword(byte[] password) { this.password = password; }
  public byte[] getSalt() { return salt; }
  public void setSalt(byte[] salt) { this.salt = salt; }
  public Role getRole() { return role; }
  public void setRole(Role role) { this.role = role; }
}
