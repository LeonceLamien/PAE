package be.vinci.pae.services.dao;

import be.vinci.pae.domain.dto.UserDTO;

public interface UserDAO {

  /**
   * {@inheritDoc} This method returns a user DTO fulfilled from the database with the pseudo that
   * was given.
   *
   * @param pseudo - UserDTO.
   * @return The userDTO or null if not found.
   */
  UserDTO trouveParPseudo(String pseudo);
}
