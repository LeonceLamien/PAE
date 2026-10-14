package be.vinci.pae.domain.dto;

import be.vinci.pae.domain.impl.UserImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = UserImpl.class)
public interface UserDTO {

  /**
   * {@inheritDoc} This method returns the statut of the user DTO.
   *
   * @return String - statut of the user.
   */
  String getStatut();

  /**
   * {@inheritDoc} This method set the statut of the user DTO.
   *
   * @param statut - String statut that is given to the user DTO.
   */
  void setStatut(String statut);

  /**
   * {@inheritDoc} This method returns the idMembre of the user DTO.
   *
   * @return int - idMembre of the user.
   */
  int getIdMembre();

  /**
   * {@inheritDoc} This method set the idMembre of the user DTO.
   *
   * @param idMembre - int idMembre that is given to the user DTO.
   */
  void setIdMembre(int idMembre);

  /**
   * {@inheritDoc} This method returns the nom of the user DTO.
   *
   * @return String - nom of the user.
   */
  String getNom();

  /**
   * {@inheritDoc} This method set the nom of the user DTO.
   *
   * @param nom - String nom that is given to the user DTO.
   */
  void setNom(String nom);

  /**
   * {@inheritDoc} This method returns the prenom of the user DTO.
   *
   * @return String - prenom of the user.
   */
  String getPrenom();

  /**
   * {@inheritDoc} This method set the prenom of the user DTO.
   *
   * @param prenom - String prenom that is given to the user DTO.
   */
  void setPrenom(String prenom);

  /**
   * {@inheritDoc} This method returns the pseudo of the user DTO.
   *
   * @return String - pseudo of the user.
   */
  String getPseudo();

  /**
   * {@inheritDoc} This method set the pseudo of the user DTO.
   *
   * @param pseudo - String pseudo that is given to the user DTO.
   */
  void setPseudo(String pseudo);

  /**
   * {@inheritDoc} This method returns the motDePasse of the user DTO.
   *
   * @return String - motDePasse of the user.
   */
  String getMotDePasse();

  /**
   * {@inheritDoc} This method set the motDePasse of the user DTO.
   *
   * @param motDePasse - String motDePasse that is given to the user DTO.
   */
  void setMotDePasse(String motDePasse);

  /**
   * {@inheritDoc} This method returns the raisonRefus of the user DTO.
   *
   * @return String - raisonRefus of the user.
   */
  String getRaisonRefus();

  /**
   * {@inheritDoc} This method set the raisonRefus of the user DTO.
   *
   * @param raisonRefus - String raisonRefus that is given to the user DTO.
   */
  void setRaisonRefus(String raisonRefus);

  /**
   * {@inheritDoc} This method returns the numeroTelephone of the user DTO.
   *
   * @return String - numeroTelephone of the user.
   */
  String getNumeroTelephone();

  /**
   * {@inheritDoc} This method set the numeroTelephone of the user DTO.
   *
   * @param numeroTelephone - String numeroTelephone that is given to the user DTO.
   */
  void setNumeroTelephone(String numeroTelephone);

  /**
   * {@inheritDoc} This method returns the address of the user DTO.
   *
   * @return String - address of the user.
   */
  int getAdresse();

  /**
   * {@inheritDoc} This method set the adresse of the user DTO.
   *
   * @param adresse - String adresse that is given to the user DTO.
   */
  void setAdresse(int adresse);

  /**
   * {@inheritDoc} This method returns the est_admin of the user DTO.
   *
   * @return String - est_admin of the user.
   */
  boolean getEstAdmin();

  /**
   * {@inheritDoc} This method set the estAdmin of the user DTO.
   *
   * @param estAdmin - String estAdmin that is given to the user DTO.
   */
  void setEstAdmin(boolean estAdmin);
}
