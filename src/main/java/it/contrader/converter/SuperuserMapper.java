package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.SuperuserDTO;
import it.contrader.model.Superuser;

@Mapper( componentModel="spring" )
public interface SuperuserMapper extends GenericMapper<Superuser,SuperuserDTO> {

}
