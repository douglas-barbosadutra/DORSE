package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.ThingDTO;
import it.contrader.model.Thing;

@Mapper( componentModel="spring" )
public interface ThingMapper extends GenericMapper<Thing,ThingDTO> {

}