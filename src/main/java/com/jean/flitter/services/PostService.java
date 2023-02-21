package com.jean.flitter.services;

import com.jean.flitter.dtos.requests.NewPostRequest;
import com.jean.flitter.entities.Post;
import com.jean.flitter.entities.User;
import com.jean.flitter.repositories.PostRepository;
import com.jean.flitter.repositories.UserRepository;
import com.jean.flitter.utils.custom_exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The PostService class provides methods for accessing and manipulating post
 * data.
 */
@Service
@Transactional
public class PostService {
  /**
   * The post repository used to access and manipulate post data.
   */
  private PostRepository postRepository;

  /**
   * The user repository used to access and manipulate user data.
   */
  private UserRepository userRepository;

  /**
   * Creates a new PostService object.
   */
  public PostService(PostRepository postRepo, UserRepository userRepo) {
    postRepository = postRepo;
    userRepository = userRepo;
  }

  /**
   * Creates a new post with the given content and user ID.
   *
   * @param request the request containing the content and user ID for the new
   *     post
   * @return the new post object
   */
  public Post createPost(NewPostRequest request) {
    Optional<User> user = userRepository.findById(request.getUserId());

    if (!user.isPresent()) {
      throw new UserNotFoundException(
          "User not found with ID: " + request.getUserId() + ".");
    }

    Post post = new Post(request, user.get());
    return postRepository.save(post);
  }
}
