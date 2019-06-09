package it.contrader.web.rest;


import it.contrader.service.dto.EventDTO;

import org.springframework.web.bind.annotation.*;



/**
 * REST controller for managing Event.
 */
@RestController
@RequestMapping("/api/event")
public class EventResource extends AbstractResource<EventDTO>{

}