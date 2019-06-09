package it.contrader.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.domain.Event;
import it.contrader.service.AbstractService;
import it.contrader.service.dto.EventDTO;


/**
 * Service Implementation for managing Event.
 */
@Service
@Transactional
public class EventService extends AbstractService<Event, EventDTO>{}