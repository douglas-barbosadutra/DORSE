package it.contrader.converter;

import org.mapstruct.Mapper;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

@Mapper( componentModel="spring" )
public interface ClientMapper extends GenericMapper<Client, ClientDTO> {

}
