package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ThingDTO;
import it.contrader.model.Thing;



@RestController
@RequestMapping("/thing")
@CrossOrigin(origins = "http://localhost:4200")
public class ThingController extends AbstractController<Thing, ThingDTO>{
	
	//ALL crud methods in AbstractController
}
