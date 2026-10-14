package be.vinci.pae.domain.impl;

import be.vinci.pae.domain.interf.Address;
import be.vinci.pae.views.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

/*
 * ignore all null fields in order to avoid sending props not linked to a JSON view
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AddressImpl implements Address {

  @JsonView(Views.Public.class)
  private int idAddress;
  @JsonView(Views.Public.class)
  private String street;
  @JsonView(Views.Public.class)
  private int buildingNumber;
  @JsonView(Views.Public.class)
  private String unitNumber;
  @JsonView(Views.Public.class)
  private int postCode;
  @JsonView(Views.Public.class)
  private String commune;

  @Override
  public int getIdAddress() {
    return this.idAddress;
  }

  @Override
  public void setIdAddress(int idAddress) {
    this.idAddress = idAddress;

  }

  @Override
  public String getStreet() {
    return this.street;
  }

  @Override
  public void setStreet(String street) {
    this.street = street;

  }

  @Override
  public int getBuildingNumber() {
    return this.buildingNumber;
  }

  @Override
  public void setBuildingNumber(int buildingNumber) {
    this.buildingNumber = buildingNumber;

  }

  @Override
  public String getUnitNumber() {
    return this.unitNumber;
  }

  @Override
  public void setUnitNumber(String unitNumber) {
    this.unitNumber = unitNumber;

  }

  @Override
  public int getPostcode() {
    return this.postCode;
  }

  @Override
  public void setPostcode(int postcode) {
    this.postCode = postcode;

  }

  @Override
  public String getCommune() {
    return this.commune;
  }

  @Override
  public void setCommune(String commune) {
    this.commune = commune;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + idAddress;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AddressImpl other = (AddressImpl) obj;
    if (idAddress != other.idAddress) {
      return false;
    }
    return true;
  }


}
