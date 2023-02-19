package com.jean.flitter.controllers;

import com.jean.flitter.dtos.requests.NewUserRequest;
import com.jean.flitter.services.UserService;
import com.jean.flitter.utils.custom_exceptions.InvalidAuthException;
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
@RequestMapping("/auth")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

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

  @ExceptionHandler(InvalidAuthException.class)
  public ResponseEntity<Object>
  handleInvalidAuthException(InvalidAuthException e) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("Timestamp", LocalTime.now());
    body.put("Message", e.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
  }
}
