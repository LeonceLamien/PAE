package be.vinci.pae.domain.impl;

import be.vinci.pae.domain.interf.User;
import be.vinci.pae.views.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Arrays;
import java.util.Objects;
import org.mindrot.jbcrypt.BCrypt;

/*
 * ignore all null fields in order to avoid sending props not linked to a JSON view
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserImpl implements User {

  @JsonView(Views.Internal.class)
  private static final String[] STATUT_POSSIBLE = {"refuse", "accepte", "en_attente"};
  @JsonView(Views.Public.class)
  private String statut;
  @JsonView(Views.Public.class)
  private Boolean estAdmin;
  @JsonView(Views.Public.class)
  private int idMembre;
  @JsonView(Views.Public.class)
  private String nom;
  @JsonView(Views.Public.class)
  private String prenom;
  @JsonView(Views.Public.class)
  private String pseudo;
  @JsonView(Views.Internal.class)
  private String motDePasse;
  @JsonView(Views.Public.class)
  private String raisonRefus;
  @JsonView(Views.Public.class)
  private String numeroTelephone;
  @JsonView(Views.Public.class)
  private int address;

  @Override
  public boolean getEstAdmin() {
    return this.estAdmin;
  }

  @Override
  public void setEstAdmin(boolean estAdmin) {
    this.estAdmin = estAdmin;
  }

  @Override
  public boolean checkPassword(String password) {
    /*
    if (password.equals(this.mot_de_passe)) {
      return true;
    }
    return false;
     */
    return BCrypt.checkpw(password, this.motDePasse);
  }

  @Override
  public String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  @Override
  public String getStatut() {
    return this.statut;
  }

  @Override
  public void setStatut(String statut) {
    Arrays.stream(STATUT_POSSIBLE).filter(statutPossible -> statutPossible.equals(statut))
        .findFirst().orElse(null);
  }

  @Override
  public int getIdMembre() {
    return this.idMembre;
  }

  @Override
  public void setIdMembre(int idMembre) {
    this.idMembre = idMembre;
  }

  @Override
  public String getNom() {
    return this.nom;
  }

  @Override
  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public String getPrenom() {
    return this.prenom;
  }

  @Override
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Override
  public String getPseudo() {
    return this.pseudo;
  }

  @Override
  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  @Override
  public String getMotDePasse() {
    return this.motDePasse;
  }

  @Override
  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  @Override
  public String getRaisonRefus() {
    return this.raisonRefus;
  }

  @Override
  public void setRaisonRefus(String raisonRefus) {
    this.raisonRefus = raisonRefus;
  }

  @Override
  public String getNumeroTelephone() {
    return this.numeroTelephone;
  }

  @Override
  public void setNumeroTelephone(String numeroTelephone) {
    this.numeroTelephone = numeroTelephone;
  }

  @Override
  public int getAdresse() {
    return this.address;
  }

  @Override
  public void setAdresse(int adresse) {
    this.address = adresse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserImpl)) {
      return false;
    }
    UserImpl user = (UserImpl) o;
    return getIdMembre() == user.getIdMembre();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIdMembre());
  }

  @Override
  public String toString() {
    return "UserImpl{"
        + "id_membre=" + idMembre
        + ", nom='" + nom + '\''
        + ", prenom='" + prenom + '\''
        + ", pseudo='" + pseudo + '\''
        + ", mot_de_passe='" + motDePasse + '\''
        + ", raison_refus='" + raisonRefus + '\''
        + ", numero_telephone='" + numeroTelephone + '\''
        + ", adresse='" + address + '\''
        + '}';
  }
}
