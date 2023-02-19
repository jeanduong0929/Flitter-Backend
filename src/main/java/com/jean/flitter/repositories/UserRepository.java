package com.jean.flitter.repositories;

import com.jean.flitter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository interface provides database access methods for the User
 * entity.
 *
 * This interface extends the JpaRepository interface provided by Spring Data
 * JPA, which provides standard CRUD operations and queries for the User entity.
 * The first type parameter is the entity type (User), and the second type
 * parameter is the type of the entity's primary key (String).
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {}
