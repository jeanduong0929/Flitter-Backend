package com.jean.flitter.services;

import com.jean.flitter.dtos.requests.NewUserRequest;
import com.jean.flitter.entities.Role;
import com.jean.flitter.entities.User;
import com.jean.flitter.repositories.UserRepository;
import com.jean.flitter.utils.custom_exceptions.CannotCreateUserException;
import jakarta.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

/**
 * The UserService class provides methods for creating users, validating
 * usernames and passwords, and checking if a username is already taken.
 */
@Service
@Transactional
public class UserService {
  /**
   * The user repository used to access the database.
   */
  private final UserRepository userRepo;

  /**
   * The role service used to assign roles to new users.
   */
  private final RoleService roleService;

  /**
   * The security service used to hash passwords and generate salt values.
   */
  private final SecurityService securityService;

  /**
   * Constructs a UserService object with the given user repository, role
   * service, and security service.
   *
   * @param userRepo the user repository used to access the database
   * @param roleService the role service used to assign roles to new users
   * @param securityService the security service used to hash passwords and
   *     generate salt values
   */
  public UserService(UserRepository userRepo, RoleService roleService,
                     SecurityService securityService) {
    this.userRepo = userRepo;
    this.roleService = roleService;
    this.securityService = securityService;
  }

  /**
   * Creates a new user with the given username and password.
   *
   * @param req the request containing the username and password for the new
   *     user
   * @return the new user object
   * @throws CannotCreateUserException if an error occurs during user creation
   */
  public User createUser(NewUserRequest req) {
    try {
      Role defaultRole = roleService.getDefaultRole();
      byte[] salt = securityService.generateSalt();
      byte[] password = securityService.hashingMethod(req.getPassword1(), salt);
      User newUser = new User(req, password, salt, defaultRole);
      userRepo.save(newUser);
      return newUser;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    throw new CannotCreateUserException("Cannot create user");
  }

  /**
   * Validates that the given username is between 8 and 20 characters long and
   * contains only letters, numbers, periods, and underscores.
   *
   * @param username the username to validate
   * @return true if the username is valid, false otherwise
   */
  public boolean isValidUsername(String username) {
    return username.matches(
        "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
  }

  /**
   * Checks if the given username is already taken by another user.
   *
   * @param username the username to check
   * @return true if the username is unique, false otherwise
   */
  public boolean isUniqueUsername(String username) {
    return userRepo.findAll().stream().noneMatch(
        (u) -> u.getUsername().equals(username));
  }

  /**
   * Validates that the given password is at least 8 characters long and
   * contains at least one letter and one number.
   *
   * @param password the password to validate
   * @return true if the password is valid, false otherwise
   */
  public boolean isValidPassword(String password) {
    return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
  }

  /**
   * Checks if the two given passwords are equal.
   *
   * @param password1 the first password
   * @param password2 the second password
   * @return true if the passwords are equal, false otherwise
   */
  public boolean isEqualPassword(String password1, String password2) {
    return password1.equals(password2);
  }
}
