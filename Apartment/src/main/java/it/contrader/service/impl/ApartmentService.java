package it.contrader.service.impl;

import it.contrader.service.AbstractService;
import it.contrader.service.dto.ApartmentDTO;
import it.contrader.domain.Apartment;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Apartment.
 */
@Service
@Transactional
public class ApartmentService extends AbstractService<Apartment, ApartmentDTO> {
	

//all Crud methods in AbstractService
}
