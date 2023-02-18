package com.jean.flitter.repositories;

import com.jean.flitter.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The RoleRepository interface extends the JpaRepository interface and defines
 * database operations for roles.
 *
 * This interface provides methods for common CRUD operations (Create, Read,
 * Update, Delete) and allows you to perform additional operations if needed.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
