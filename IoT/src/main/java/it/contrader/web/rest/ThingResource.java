package it.contrader.web.rest;


import it.contrader.service.dto.ThingDTO;

import org.springframework.web.bind.annotation.*;


/**
 * REST controller for managing Thing.
 */
@RestController
@RequestMapping("/api/thing")
public class ThingResource extends AbstractResource<ThingDTO>{

}