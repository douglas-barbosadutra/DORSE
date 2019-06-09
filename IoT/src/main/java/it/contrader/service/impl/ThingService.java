package it.contrader.service.impl;

import it.contrader.service.AbstractService;
import it.contrader.domain.Thing;
import it.contrader.service.dto.ThingDTO;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Thing.
 */
@Service
@Transactional
public class ThingService extends AbstractService<Thing, ThingDTO>{
	
}