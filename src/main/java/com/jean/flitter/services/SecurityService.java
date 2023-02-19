package com.jean.flitter.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.springframework.stereotype.Service;

/**
 * Provides methods for generating a salt and hashing a password using a
 * secure algorithm.
 */
@Service
public class SecurityService {

  /**
   * Generates a random salt value to be used in password hashing.
   *
   * @return the generated salt value
   */
  public byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

  /**
   * Hashes a password using the SHA-512 algorithm and the provided salt.
   *
   * @param password the password to hash
   * @param salt the salt value to use in the hash
   * @return the hashed password
   * @throws NoSuchAlgorithmException if the specified algorithm is not
   *     available
   */
  public byte[] hashingMethod(String password, byte[] salt)
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-512");
    md.update(salt);
    return md.digest(password.getBytes(StandardCharsets.UTF_8));
  }
}
