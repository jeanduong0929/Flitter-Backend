package com.jean.flitter.controllers;

import com.jean.flitter.dtos.requests.NewRoleRequest;
import com.jean.flitter.entities.Role;
import com.jean.flitter.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The RoleController class handles HTTP requests related to roles.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

  /**
   * The role service used to create roles.
   */
  private final RoleService roleService;

  /**
   * Constructs a RoleController object with the given role service.
   *
   * @param roleService the role service used to create roles
   */
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  /**
   * Handles a POST request to create a new role.
   *
   * @param req the request containing the name of the new role
   * @return a ResponseEntity containing the newly created role
   */
  @PostMapping("/create")
  public ResponseEntity<Role> createRole(@RequestBody NewRoleRequest req) {
    Role savedRole = roleService.createRole(req);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
  }
}
