package com.jean.flitter.services;

import com.jean.flitter.dtos.responses.Principal;
import com.jean.flitter.utils.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * The TokenService class provides methods for generating and extracting
 * authentication tokens.
 */
@Service
public class TokenService {
  /**
   * The JWT configuration used to generate and extract tokens.
   */
  private final JwtConfig jwtConfig;

  /**
   * Creates a new TokenService object with the given JWT configuration.
   *
   * @param jwtConfig the JWT configuration used to generate and extract tokens
   */
  public TokenService(JwtConfig jwtConfig) { this.jwtConfig = jwtConfig; }

  /**
   * Generates a new authentication token for the given subject.
   *
   * The token is generated using the JWT builder. The token is signed with
   * the configured signing key and algorithm. The token is set to expire
   * after the configured expiration time.
   *
   * @param subject the subject of the token
   * @return the generated token
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
   * Extracts the subject of the given token.
   *
   * The token is parsed using the JWT parser. The token is verified using
   * the configured signing key and algorithm. The token is then parsed
   * into a claims object. The claims object is then used to create a new
   * Principal object.
   *
   * @param token the token to extract the subject from
   * @return the subject of the token
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
