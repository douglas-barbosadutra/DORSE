package it.contrader.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.*;
import it.contrader.service.*;


@Controller
@RequestMapping("/client")
public class ClientController {

	private ClientService clientService;
	private ApartmentService apartmentService;
	private TutorService tutorService;
	
	@Autowired
	public ClientController(ClientService clientService, ApartmentService apartmentService, TutorService tutorService) {
		this.clientService = clientService;
		this.apartmentService = apartmentService;
		this.tutorService = tutorService;
		
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname,
			@RequestParam(value = "birthdate") String birthdate,
			@RequestParam(value = "telnumber") String telnumber,
			@RequestParam(value = "apartment_id") String apartment_idstr,
			@RequestParam(value = "tutor_id") String tutor_idstr
			) 
	{
		
		long tutor_id = Long.parseLong(tutor_idstr);
		long apartment_id = Long.parseLong(apartment_idstr);
		
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

			TutorDTO tutorDTO = tutorService.read(tutor_id) ;
			ApartmentDTO apartmentDTO = apartmentService.read(apartment_id);
			ClientDTO clientDTO= new ClientDTO();
			clientDTO.setName(name);
			clientDTO.setSurname(surname);
			clientDTO.setTelnumber(telnumber);
			clientDTO.setBirthdate(date);
			clientDTO.setTutorDTO(tutorDTO);
			clientDTO.setApartmentDTO(apartmentDTO);
			
			
			clientService.insert(clientDTO);
			
			
			
			return "hometutor";
						
	}
	
}
