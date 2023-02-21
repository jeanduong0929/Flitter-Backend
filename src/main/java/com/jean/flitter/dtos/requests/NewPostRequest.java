package com.jean.flitter.dtos.requests;

import com.jean.flitter.entities.Post;

public class NewPostRequest {
  /**
   * The content of the post.
   */
  private String content;

  /**
   * The ID of the user associated with the post.
   */
  private String userId;

  /**
   * Creates a new NewPostRequest object.
   */
  public NewPostRequest() {}

  /**
   * Creates a new NewPostRequest object with the given content and user ID.
   *
   * @param content The content of the post.
   * @param userId The ID of the user associated with the post.
   */
  public NewPostRequest(String content, String userId) {
    this.content = content;
    this.userId = userId;
  }

  /**
   * Returns the content of the post.
   *
   * @return The content of the post.
   */
  public String getContent() { return content; }

  /**
   * Sets the content of the post.
   *
   * @param content The content of the post.
   */
  public void setContent(String content) { this.content = content; }

  /**
   * Returns the ID of the user associated with the post.
   *
   * @return The ID of the user associated with the post.
   */
  public String getUserId() { return userId; }

  /**
   * Sets the ID of the user associated with the post.
   *
   * @param userId The ID of the user associated with the post.
   */
  public void setUserId(String userId) { this.userId = userId; }
}
