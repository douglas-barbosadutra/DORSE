package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.EventDTO;
import it.contrader.dto.ItemDTO;
import it.contrader.model.Event;
import it.contrader.model.Item;

@Component
public class EventConverter extends AbstractConverter<Event, EventDTO> {

	@Autowired
	private ItemConverter itemConverter;
	
	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = new Event();
		if (eventDTO != null) {
			event.setId(eventDTO.getId());
			event.setTime(eventDTO.getTime());
			event.setItem(itemConverter.toEntity(eventDTO.getItemDTO()));
		}
		return event;
	}
	
	@Override
	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = new EventDTO();
		if (event != null) {
			eventDTO.setId(event.getId());
			eventDTO.setTime(event.getTime());
			eventDTO.setItemDTO(itemConverter.toDTO(event.getItem()));
		}
		return eventDTO;
	}
}
