package be.vinci.pae.services.dao;

import be.vinci.pae.domain.dto.AddressDTO;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

  //@Inject
  //private DalServices dalServices;

  //@Inject
  //private DomainFactory domainFactory;

  @Override
  public List<AddressDTO> findAll() {
    return null;
  }

  @Override
  public AddressDTO findByID(int addressID) {
    return null;
  }

  @Override
  public List<AddressDTO> findByPostcode(int postalCode) {
    return null;
  }

  @Override
  public List<AddressDTO> findByCommune(String municipality) {
    return null;
  }

  @Override
  public int insert(AddressDTO address) {
    return -1;
  }

  @Override
  public boolean delete(AddressDTO address) {
    return false;
  }

  @Override
  public AddressDTO update(AddressDTO address) {
    return null;
  }

  /* unused
  private AddressDTO setAddress(ResultSet rs) {
    return null;
  }
  */

  @Override
  public int findByAllAttributes(AddressDTO address) {
    return -1;
  }

}
