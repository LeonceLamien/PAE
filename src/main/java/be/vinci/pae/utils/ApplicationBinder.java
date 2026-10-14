package be.vinci.pae.utils;

import be.vinci.pae.domain.DomainFactory;
import be.vinci.pae.domain.DomainFactoryImpl;
import be.vinci.pae.domain.ucc.UserUCC;
import be.vinci.pae.domain.ucc.UserUCCImpl;
import be.vinci.pae.services.DalServices;
import be.vinci.pae.services.DalServicesImpl;
import be.vinci.pae.services.dao.AddressDAO;
import be.vinci.pae.services.dao.AddressDAOImpl;
import be.vinci.pae.services.dao.UserDAO;
import be.vinci.pae.services.dao.UserDAOImpl;
import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

@Provider
public class ApplicationBinder extends AbstractBinder {

  @Override
  protected void configure() {
    bind(DomainFactoryImpl.class).to(DomainFactory.class).in(Singleton.class);
    bind(UserUCCImpl.class).to(UserUCC.class).in(Singleton.class);
    bind(UserDAOImpl.class).to(UserDAO.class).in(Singleton.class);
    bind(AddressDAOImpl.class).to(AddressDAO.class).in(Singleton.class);
    bind(DalServicesImpl.class).to(DalServices.class).in(Singleton.class);

  }
}
