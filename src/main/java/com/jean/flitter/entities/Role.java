package com.jean.flitter.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jean.flitter.dtos.requests.NewRoleRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
   * The list of users assigned to the role.
   *
   * This list is annotated with @OneToMany to indicate that there is a
   * one-to-many relationship between roles and users. The mappedBy attribute is
   * used to specify the field in the User class that maps to this list.
   *
   * The cascade attribute is set to CascadeType.ALL, which means that all
   * changes made to the role will be cascaded to the users in this list. This
   * includes updates, inserts, and deletes.
   *
   * The fetch attribute is set to FetchType.EAGER, which means that the list of
   * users will be eagerly loaded from the database when the Role object is
   * retrieved. This can improve performance by reducing the number of database
   * queries needed to load the list of users.
   *
   * The @JsonManagedReference annotation is used to prevent infinite recursion
   * when serializing the object to JSON. This is necessary because the User
   * object has a reference back to the Role object, and without this
   * annotation, the serialization process would enter an infinite loop.
   */
  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL,
             fetch = FetchType.EAGER)
  @JsonManagedReference
  private List<User> users;

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
