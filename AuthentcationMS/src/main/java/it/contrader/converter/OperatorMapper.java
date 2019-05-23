package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.OperatorDTO;
import it.contrader.model.Operator;

@Mapper( componentModel="spring" )
public interface OperatorMapper extends GenericMapper<Operator,OperatorDTO> {

}

