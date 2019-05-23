package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;


@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController extends AbstractController<Client, ClientDTO> {
	
	//ALL crud methods in AbstractController
}
