package com.jean.flitter.services;

import com.jean.flitter.dtos.requests.NewRoleRequest;
import com.jean.flitter.entities.Role;
import com.jean.flitter.repositories.RoleRepository;
import com.jean.flitter.utils.custom_exceptions.RoleNotFoundException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The RoleService class provides methods for creating and retrieving roles from
 * the database.
 */
@Service
@Transactional
public class RoleService {

  /**
   * The role repository used to access the database.
   */
  private final RoleRepository roleRepo;

  /**
   * Constructs a RoleService object with the given role repository.
   *
   * @param roleRepo the role repository used to access the database
   */
  public RoleService(RoleRepository roleRepo) { this.roleRepo = roleRepo; }

  /**
   * Creates a new role with the given name and saves it to the database.
   *
   * @param req the request containing the name of the new role
   * @return the newly created role
   */
  public Role createRole(NewRoleRequest req) {
    Role newRole = new Role(req);
    roleRepo.save(newRole);
    return newRole;
  }

  /**
   * Returns the default role from the database.
   *
   * @return the default role
   * @throws RoleNotFoundException if no role with the name "DEFAULT" is found
   *     in the database
   */
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
