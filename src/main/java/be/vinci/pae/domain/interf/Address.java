package be.vinci.pae.domain.interf;

import be.vinci.pae.domain.dto.AddressDTO;
import be.vinci.pae.domain.impl.AddressImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AddressImpl.class)

public interface Address extends AddressDTO {

}
