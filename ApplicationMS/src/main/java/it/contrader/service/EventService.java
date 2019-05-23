package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.converter.CycleAvoidingMappingContext;
import it.contrader.dao.EventRepository;
import it.contrader.dto.DateDTO;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

@Service
public class EventService extends AbstractService<Event,EventDTO> {

	//ALL crud methods in AbstractService
	
	public Iterable<EventDTO> findAllByItemAndDate(DateDTO date){
		return mapper.toDTO(((EventRepository)myRepository).findAllByItemAndDate(date.getId(), date.getDate()), new CycleAvoidingMappingContext());
	}
}
;