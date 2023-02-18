package com.jean.flitter.entities;

import com.jean.flitter.dtos.requests.NewRoleRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.ToString;

@Entity
@ToString
@Table(name = "fl_role")
public class Role {
  @Id private String id;
  @Column(name = "user_role", nullable = false) private String userRole;

  public Role() {}
  public Role(NewRoleRequest req) {
    this.id = UUID.randomUUID().toString();
    this.userRole = req.getUserRole();
  }
  public Role(String id, String userRole) {
    this.id = id;
    this.userRole = userRole;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getUserRole() { return userRole; }
  public void setUserRole(String userRole) { this.userRole = userRole; }
}
