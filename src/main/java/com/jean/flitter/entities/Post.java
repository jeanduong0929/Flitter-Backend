package com.jean.flitter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jean.flitter.dtos.requests.NewPostRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.ToString;

/**
 * The Post class represents a post made by a user.
 *
 * This class contains the post's ID and content.
 */
@Entity
@Table(name = "posts")
@ToString
public class Post {
  /**
   * The unique ID of the post.
   */
  @Id @Column(name = "id") private String id;

  /**
   * The content of the post.
   */
  @Column(name = "content") private String content;

  /**
   * The user associated with the post.
   */
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  /**
   * Creates a new Post object.
   */
  public Post() {}

  /**
   * Creates a new Post object.
   *
   * @param request The request containing the post's content.
   * @param user The user associated with the post.
   */
  public Post(NewPostRequest request, User user) {
    this.id = UUID.randomUUID().toString();
    this.content = request.getContent();
    this.user = user;
  }

  /**
   * Creates a new Post object.
   *
   * @param id The ID of the post.
   * @param content The content of the post.
   */
  public Post(String id, String content) {
    this.id = id;
    this.content = content;
  }

  /**
   * Returns the ID of the post.
   *
   * @return The ID of the post.
   */
  public String getId() { return id; }

  /**
   * Sets the ID of the post.
   *
   * @param id The ID of the post.
   */
  public void setId(String id) { this.id = id; }

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
}
