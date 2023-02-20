package com.jean.flitter.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {
  private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
  private final Key signingKey;

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

  public int getExpiration() { return 60 * 60 * 1000; }
  public SignatureAlgorithm getSigAlg() { return sigAlg; }
  public Key getSigningKey() { return signingKey; }
}
