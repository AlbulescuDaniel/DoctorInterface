package utility;

import java.time.LocalDateTime;
import java.time.ZoneId;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JWTInfo {

  private String user;
  private String role;
  private LocalDateTime expirationDate;

  public JWTInfo(String token) {
    super();
    Jws<Claims> claims = null;
    try {
      claims = Jwts.parser().setSigningKey("{noop}ThisIsASecret").parseClaimsJws(token.replaceAll("Bearer ", ""));
      this.role = claims.getBody().get("authority").toString().replace("[{authority=", "").replace("}]", "");
      this.user = claims.getBody().getSubject();
      this.expirationDate = LocalDateTime.ofInstant(claims.getBody().getExpiration().toInstant(), ZoneId.systemDefault());
    }
    catch (ExpiredJwtException e) {
    }
  }

  public String getUser() {
    return user;
  }

  public String getRole() {
    return role;
  }

  public LocalDateTime getExpirationDate() {
    return expirationDate;
  }

  @Override
  public String toString() {
    return "user = " + user + "\nrole = " + role + "\nexpirationDate = " + expirationDate;
  }
}
