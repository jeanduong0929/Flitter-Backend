package com.jean.flitter.controllers;

import com.jean.flitter.dtos.requests.NewPostRequest;
import com.jean.flitter.services.PostService;
import com.jean.flitter.utils.custom_exceptions.UserNotFoundException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
  /**
   * The post service used to create posts.
   */
  private final PostService postService;

  /**
   * Constructs a PostController object with the given post service.
   *
   * @param postService the post service used to create posts
   */
  public PostController(PostService postService) {
    this.postService = postService;
  }

  /**
   * Handles a POST request to create a new post.
   *
   * @param request the request containing the content and user ID for the new
   *     post
   * @return a ResponseEntity with a message indicating the post was
   *     successfully created
   */
  @PostMapping("/create")
  public ResponseEntity<?> createPost(@RequestBody NewPostRequest request) {
    postService.createPost(request);
    return ResponseEntity.ok("Post created");
  }

  /**
   * Handles a UserNotFoundException by returning a 404 response with a message.
   *
   * @param e the UserNotFoundException thrown
   * @return a ResponseEntity with a 404 status and a message
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Map<String, Object>>
  handleUserNotFoundException(UserNotFoundException e) {
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("timestamp", LocalTime.now());
    response.put("message", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
