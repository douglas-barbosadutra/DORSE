package it.contrader.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.EventRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.ThingDTO;
import it.contrader.model.Event;
import it.contrader.model.Thing;

@Service
public class EventService extends AbstractService<Event,EventDTO> {

	//ALL crud methods in AbstractService
	
	public List<EventDTO> findAllByItemAndDate(Long id, Date date){
		return converter.toDTOList(((EventRepository)myRepository).findAllByItemAndDate(id, date));
	}
}
