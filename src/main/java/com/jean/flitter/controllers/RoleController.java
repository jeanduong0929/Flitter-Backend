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

@RestController
@RequestMapping("/roles")
public class RoleController {
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping
  public ResponseEntity<Role> createRole(@RequestBody NewRoleRequest req) {
    Role savedRole = roleService.createRole(req);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
  }
}
