package com.jean.flitter.entities;

import com.jean.flitter.dtos.requests.NewRoleRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.ToString;

/**
 * The Role class represents a role that can be assigned to a user.
 *
 * A Role object contains the role's id and name.
 */
@Entity
@ToString
@Table(name = "fl_role")
public class Role {

  /**
   * The id of the role.
   */
  @Id private String id;

  /**
   * The name of the role.
   */
  @Column(name = "user_role", nullable = false) private String userRole;

  /**
   * Constructs an empty Role object.
   */
  public Role() {}

  /**
   * Constructs a Role object with the given role name.
   *
   * @param req the request containing the name of the role to create
   */
  public Role(NewRoleRequest req) {
    this.id = UUID.randomUUID().toString();
    this.userRole = req.getUserRole();
  }

  /**
   * Constructs a Role object with the given id and role name.
   *
   * @param id the id of the role
   * @param userRole the name of the role
   */
  public Role(String id, String userRole) {
    this.id = id;
    this.userRole = userRole;
  }

  /**
   * Returns the id of the role.
   *
   * @return the id of the role
   */
  public String getId() { return id; }

  /**
   * Sets the id of the role.
   *
   * @param id the id to set for the role
   */
  public void setId(String id) { this.id = id; }

  /**
   * Returns the name of the role.
   *
   * @return the name of the role
   */
  public String getUserRole() { return userRole; }

  /**
   * Sets the name of the role.
   *
   * @param userRole the name to set for the role
   */
  public void setUserRole(String userRole) { this.userRole = userRole; }
}
