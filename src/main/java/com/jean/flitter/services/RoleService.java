package com.jean.flitter.services;

import com.jean.flitter.dtos.requests.NewRoleRequest;
import com.jean.flitter.entities.Role;
import com.jean.flitter.repositories.RoleRepository;
import com.jean.flitter.utils.custom_exceptions.RoleNotFoundException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
  private final RoleRepository roleRepo;

  public RoleService(RoleRepository roleRepo) { this.roleRepo = roleRepo; }

  public Role createRole(NewRoleRequest req) {
    Role newRole = new Role(req);
    roleRepo.save(newRole);
    return newRole;
  }

  public Role getDefaultRole() {
    Optional<Role> optionalRole =
        roleRepo.findAll()
            .stream()
            .filter((r) -> r.getUserRole().equals("DEFAULT"))
            .findFirst();

    if (!optionalRole.isPresent())
      throw new RoleNotFoundException("DEFAULT");

    return optionalRole.get();
  }
}
