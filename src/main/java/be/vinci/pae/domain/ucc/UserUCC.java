package be.vinci.pae.domain.ucc;

import be.vinci.pae.domain.dto.UserDTO;

public interface UserUCC {

  /**
   * {@inheritDoc}This method is the use case method.
   *
   * @param username - String , username of the user.
   * @param password - String , password of the user.
   * @return UserDTO with full fields or null if the user is not found.
   */
  UserDTO login(String username, String password);

  /**
   * {@inheritDoc}This method is the use case method.
   *
   * @param username - String , username of the user.
   * @return UserDTO with full fields or null if the user is not found.
   */
  UserDTO getUser(String username);
}
