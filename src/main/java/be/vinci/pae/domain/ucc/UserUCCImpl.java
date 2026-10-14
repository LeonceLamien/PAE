package be.vinci.pae.domain.ucc;

import be.vinci.pae.domain.dto.UserDTO;
import be.vinci.pae.domain.interf.User;
import be.vinci.pae.services.dao.UserDAO;
import jakarta.inject.Inject;

public class UserUCCImpl implements UserUCC {

  //@Inject
  ///private DomainFactory domainFactory;

  @Inject
  private UserDAO userDao;

  //@Inject
  //private AddressDAO addressDao;


  @Override
  public UserDTO login(String username, String password) {
    UserDTO userDTO = null;

    try {
      userDTO = this.userDao.trouveParPseudo(username);
      if (userDTO == null) {
        System.out.println("UserDTO NULL - UserUCCImpl");
        return null;
      }

      User user = (User) userDTO;

      if (user == null || !user.checkPassword(password)) {
        System.out.println("User NULL | password pas bon - UserUCCImpl");
        return null;
      }

      userDTO = (UserDTO) user;

      return userDTO;
    } catch (Exception e) {
      System.out.println("Erreur Login - UserUCCImpl");
      return null;
    }
  }

  @Override
  public UserDTO getUser(String username) {
    return null;
  }
}


