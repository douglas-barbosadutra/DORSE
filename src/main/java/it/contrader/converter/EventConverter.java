package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

@Component
public class EventConverter extends AbstractConverter<Event, EventDTO> {

}
