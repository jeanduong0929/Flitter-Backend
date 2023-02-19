package com.jean.flitter.services;

import com.jean.flitter.dtos.requests.NewUserRequest;
import com.jean.flitter.entities.Role;
import com.jean.flitter.entities.User;
import com.jean.flitter.repositories.UserRepository;
import com.jean.flitter.utils.custom_exceptions.CannotCreateUserException;
import jakarta.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepo;
  private final RoleService roleService;
  private final SecurityService securityService;

  public UserService(UserRepository userRepo, RoleService roleService,
                     SecurityService securityService) {
    this.userRepo = userRepo;
    this.roleService = roleService;
    this.securityService = securityService;
  }

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

  public boolean isValidUsername(String username) {
    return username.matches(
        "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
  }

  public boolean isUniqueUsername(String username) {
    return userRepo.findAll().stream().noneMatch(
        (u) -> u.getUsername().equals(username));
  }

  public boolean isValidPassword(String password) {
    return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
  }

  public boolean isEqualPassword(String password1, String password2) {
    return password1.equals(password2);
  }
}
