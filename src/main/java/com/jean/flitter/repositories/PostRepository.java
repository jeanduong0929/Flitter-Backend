package com.jean.flitter.repositories;

import com.jean.flitter.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The PostRepository interface provides methods for accessing and manipulating
 * post data in the database.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, String> {}
