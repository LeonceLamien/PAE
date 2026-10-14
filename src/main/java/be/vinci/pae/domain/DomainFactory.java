package be.vinci.pae.domain;

import be.vinci.pae.domain.interf.Address;
import be.vinci.pae.domain.interf.User;

public interface DomainFactory {

  User getUser();

  Address getAddress();
}