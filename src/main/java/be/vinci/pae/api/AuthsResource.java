package be.vinci.pae.api;

import be.vinci.pae.domain.dto.UserDTO;
import be.vinci.pae.domain.ucc.UserUCC;
import be.vinci.pae.utils.Config;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.Date;

@Singleton
@Path("/auths")
public class AuthsResource {

  public final long expirationTime = (long) Config.getIntProperty("expirationTime");
  private final Algorithm jwtAlgorithm = Algorithm.HMAC256(Config.getProperty("JWTSecret"));
  private final ObjectMapper jsonMapper = new ObjectMapper();
  @Inject
  private UserUCC userUCC;

  /**
   * {@inheritDoc} This method log in the user
   *
   * @param json - JsonNode which contains the username
   * @return an ObjetNode which contains a token, the user's id_member and the user's username
   */
  @POST
  @Path("login")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ObjectNode login(JsonNode json) {
    if (!json.hasNonNull("username") || !json.hasNonNull("password")) {
      throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
          .entity("login or password required").type("text/plain").build());
    }
    String username = json.get("username").asText();
    String password = json.get("password").asText();
    // Try to login
    UserDTO userDTO = userUCC.login(username, password);
    if (userDTO == null) {
      throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
          .entity("Login or password incorrect").type(MediaType.TEXT_PLAIN)
          .build());
    }

    // Create token
    String token;
    try {
      token = JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
          .withIssuer("auth0").withClaim("user", userDTO.getIdMembre()).sign(this.jwtAlgorithm);
    } catch (Exception e) {
      throw new WebApplicationException("Unable to create token", e, Status.INTERNAL_SERVER_ERROR);
    }
    // Build response

    // load the user data from a public JSON view to filter out the private info not
    // to be returned by the API (such as password)
    //UserDTO publicUser = Json.filterPublicJsonView(user, UserDTO.class);
    ObjectNode publicUser = jsonMapper.createObjectNode().put("token", token)
        .put("id", userDTO.getIdMembre()).put("username", userDTO.getPseudo());

    return publicUser;
  }
}
