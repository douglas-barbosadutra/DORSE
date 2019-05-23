package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DateDTO;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;
import it.contrader.service.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController extends AbstractController<Event, EventDTO> {
	
	@Autowired
	private EventService eventService;

	//Passing date types in GET non supported by Spring (https://github.com/swagger-api/swagger-codegen/issues/4113)
	@PostMapping(value = "/event")
	public Iterable<EventDTO> getAllByItemAndDate(@RequestBody DateDTO date) {
		
		return eventService.findAllByItemAndDate(date);
	}
}
