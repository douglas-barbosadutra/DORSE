package it.contrader.converter;

import org.mapstruct.Mapper;

import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

@Mapper( componentModel="spring" )
public interface EventMapper extends GenericMapper<Event, EventDTO> {

}
