package it.contrader.converter;

import org.mapstruct.Mapper;
import it.contrader.dto.TestuserDTO;
import it.contrader.model.Testuser;

@Mapper( componentModel="spring" )
public interface TestuserMapper extends GenericMapper<Testuser,TestuserDTO> {

}
