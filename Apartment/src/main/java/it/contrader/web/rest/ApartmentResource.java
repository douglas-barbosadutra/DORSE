package it.contrader.web.rest;

import it.contrader.service.dto.ApartmentDTO;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for managing Apartment.
 */
@RestController
@RequestMapping("/api")
public class ApartmentResource extends AbstractResource<ApartmentDTO> {
	
    private static final String ENTITY_NAME = "apartment";

}