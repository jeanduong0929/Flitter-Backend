package com.jean.flitter.services;

import com.jean.flitter.dtos.responses.Principal;
import com.jean.flitter.utils.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * Service responsible for generating and validating JSON Web Tokens (JWTs).
 */
@Service
public class TokenService {
  private final JwtConfig jwtConfig;

  /**
   * Constructs a new TokenService object with the given JwtConfig object.
   * @param jwtConfig the JWT configuration to use when generating tokens.
   */
  public TokenService(JwtConfig jwtConfig) { this.jwtConfig = jwtConfig; }

  /**
   * Generates a new JWT for the given subject (user).
   * @param subject the user to generate a token for.
   * @return the generated JWT as a String.
   */
  public String generateToken(Principal subject) {
    long now = System.currentTimeMillis();
    JwtBuilder tokenBuilder =
        Jwts.builder()
            .setId(subject.getId())
            .setIssuer("flitter")
            .setIssuedAt(new Date(now))
            .setExpiration(new Date(now + jwtConfig.getExpiration()))
            .setSubject(subject.getUsername())
            .claim("role", subject.getRole())
            .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());
    return tokenBuilder.compact();
  }

  /**
   * Extracts the user details from the given JWT token.
   * @param token the JWT token to extract the user details from.
   * @return a Principal object containing the user details, or null if the
   *     token is invalid.
   */
  public Principal extractRequesterDetails(String token) {
    try {
      Claims claims = Jwts.parser()
                          .setSigningKey(jwtConfig.getSigningKey())
                          .parseClaimsJws(token)
                          .getBody();
      return new Principal(claims.getId(), claims.getSubject(),
                           claims.get("role", String.class));
    } catch (Exception e) {
      return null;
    }
  }
}
