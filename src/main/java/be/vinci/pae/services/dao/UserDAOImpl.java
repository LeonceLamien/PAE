package be.vinci.pae.services.dao;

import be.vinci.pae.domain.DomainFactory;
import be.vinci.pae.domain.dto.UserDTO;
import be.vinci.pae.services.DalServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

  private final String findUserByUsername =
      "SELECT mem.nom, mem.prenom, mem.pseudo, mem.mot_de_passe, mem.est_admin,"
          + " mem.statut, mem.raison_refus, mem.numero_telephone, mem.adresse"
          + " FROM ProjetAAE.membres mem WHERE mem.pseudo=?";
  @Inject
  private DomainFactory domainFactory;

  @Inject
  private DalServices dalServices;

  @Override
  public UserDTO trouveParPseudo(String pseudo) {
    UserDTO utilisateur = null;
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = dalServices.getPreparedStatement(findUserByUsername);
      ps.setString(1, pseudo);
      rs = ps.executeQuery();
      while (rs.next()) {
        utilisateur = setUser(rs);
      }
    } catch (SQLException e) {
      // Pas sur que bon status
      throw new WebApplicationException("Ressource not found",
          Status.INTERNAL_SERVER_ERROR);
    }
    return utilisateur;
  }


  /**
   * {@inheritDoc} this method retrieves the data of a user present in a ResultSet.
   *
   * @param rs - ResultSet.
   * @return the new user DTO.
   */
  private UserDTO setUser(ResultSet rs) {

    UserDTO user = domainFactory.getUser();

    try {
      user.setNom(rs.getString(1));
      user.setPrenom(rs.getString(2));
      user.setPseudo(rs.getString(3));
      user.setMotDePasse(rs.getString(4));
      user.setEstAdmin(rs.getBoolean(5));
      user.setStatut(rs.getString(6));
      user.setRaisonRefus(rs.getString(7));
      user.setNumeroTelephone(rs.getString(8));
      user.setAdresse(rs.getInt(9));
    } catch (Exception e) {
      // Pas sur que bon status
      throw new WebApplicationException("Ressource not found",
          Status.INTERNAL_SERVER_ERROR);
    }

    return user;
  }
}
