package be.vinci.pae.domain.interf;

import be.vinci.pae.domain.dto.UserDTO;
import be.vinci.pae.domain.impl.UserImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserImpl.class)
public interface User extends UserDTO {

  /**
   * {@inheritDoc} This method checks if the password is the same as the user's password.
   *
   * @param password - String that contains the password with Bcrypt.
   * @return true if it succeed, false if it failed. {@inheritDoc}
   */
  boolean checkPassword(String password);

  /**
   * {@inheritDoc} This method encrypts/hash the password
   *
   * @param password - String that contains the password without Bcrypt.
   * @return true if it succeed, false if it failed. {@inheritDoc}
   */
  String hashPassword(String password);
}
