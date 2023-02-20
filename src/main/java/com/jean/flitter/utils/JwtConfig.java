package com.jean.flitter.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;

/**
 * Provides configuration for JWT generation and validation.
 */
@Component
public class JwtConfig {
  /**
   * The signature algorithm used to sign the JWT.
   */
  private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;

  /**
   * The key used to sign the JWT.
   */
  private final Key signingKey;

  /**
   * Creates a new instance of JwtConfig and loads properties from an
   * application.properties file.
   */
  public JwtConfig() {
    Properties props = new Properties();
    try {
      props.load(
          new FileInputStream("src/main/resources/application.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    byte[] saltyBytes =
        DatatypeConverter.parseBase64Binary(props.getProperty("salt"));
    signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
  }

  /**
   * Gets the time, in milliseconds, that a JWT is valid for.
   *
   * @return The time, in milliseconds, that a JWT is valid for.
   */
  public int getExpiration() { return 60 * 60 * 1000; }

  /**
   * Gets the signature algorithm used to sign the JWT.
   *
   * @return The signature algorithm used to sign the JWT.
   */
  public SignatureAlgorithm getSigAlg() { return sigAlg; }

  /**
   * Gets the key used to sign the JWT.
   *
   * @return The key used to sign the JWT.
   */
  public Key getSigningKey() { return signingKey; }
}
