package com.jean.flitter.controllers;

import com.jean.flitter.dtos.requests.LoginRequest;
import com.jean.flitter.dtos.requests.NewUserRequest;
import com.jean.flitter.dtos.responses.Principal;
import com.jean.flitter.services.TokenService;
import com.jean.flitter.services.UserService;
import com.jean.flitter.utils.custom_exceptions.InvalidAuthException;
import com.jean.flitter.utils.custom_exceptions.UserNotFoundException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The UserController class handles HTTP requests related to user
 * authentication.
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

  /**
   * The user service used to create users.
   */
  private final UserService userService;

  private final TokenService tokenService;

  /**
   * Constructs a UserController object with the given user service.
   *
   * @param userService the user service used to create users
   */
  public AuthController(UserService userService, TokenService tokenService) {
    this.userService = userService;
    this.tokenService = tokenService;
  }

  /**
   * Handles a POST request to create a new user.
   *
   * @param req the request containing the username and password for the new
   *     user
   * @return a ResponseEntity with a message indicating the user was
   *     successfully created
   * @throws InvalidAuthException if the username or password in the request are
   *     invalid or already exist
   */
  @PostMapping("/register")
  public ResponseEntity<?> createUser(@RequestBody NewUserRequest req) {
    if (!userService.isValidUsername(req.getUsername()))
      throw new InvalidAuthException("Username must be 8 and 20 characters");

    if (!userService.isUniqueUsername(req.getUsername()))
      throw new InvalidAuthException("Username is already taken");

    if (!userService.isValidPassword(req.getPassword1()))
      throw new InvalidAuthException(
          "Password must minimum eight characters, at least one letter and one number");

    if (!userService.isEqualPassword(req.getPassword1(), req.getPassword2()))
      throw new InvalidAuthException("Password do not match");

    userService.createUser(req);
    return ResponseEntity.ok("User successfully created");
  }

  /**
   * Handles a POST request to login a user.
   *
   * @param req the request containing the username and password for the user
   * @return a ResponseEntity with the user's principal
   * @throws UserNotFoundException if the username or password in the request
   *     are invalid
   */
  @PostMapping("/login")
  public ResponseEntity<Principal> loginUser(@RequestBody LoginRequest req) {
    Principal principal = userService.loginUser(req);
    principal.setToken(tokenService.generateToken(principal));
    return ResponseEntity.status(HttpStatus.OK).body(principal);
  }

  /**
   * Handles an InvalidAuthException thrown by the createUser method and returns
   * a ResponseEntity with an error message and timestamp.
   *
   * @param e the InvalidAuthException thrown by the createUser method
   * @return a ResponseEntity with an error message and timestamp
   */
  @ExceptionHandler(InvalidAuthException.class)
  public ResponseEntity<Object>
  handleInvalidAuthException(InvalidAuthException e) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("Timestamp", LocalTime.now());
    body.put("Message", e.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
  }

  /**
   * Handles a UserNotFoundException thrown by the loginUser method and returns
   * a ResponseEntity with an error message and timestamp.
   *
   * @param e the UserNotFoundException thrown by the loginUser method
   * @return a ResponseEntity with an error message and timestamp
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object>
  handleUserNotFoundException(UserNotFoundException e) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("Timestamp", LocalTime.now());
    body.put("Message", e.getMessage());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
  }
}
