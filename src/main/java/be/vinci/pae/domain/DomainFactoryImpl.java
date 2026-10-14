package be.vinci.pae.domain;

import be.vinci.pae.domain.impl.AddressImpl;
import be.vinci.pae.domain.impl.UserImpl;
import be.vinci.pae.domain.interf.Address;
import be.vinci.pae.domain.interf.User;

public class DomainFactoryImpl implements DomainFactory {

  @Override
  public User getUser() {
    return new UserImpl();
  }

  public Address getAddress() {
    return new AddressImpl();
  }
}