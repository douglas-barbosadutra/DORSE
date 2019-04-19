package it.contrader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ClientDTO;
import it.contrader.service.ClientService;


@Controller
@RequestMapping("/client")
public class ClientController {

	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(

			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname,
			@RequestParam(value = "birthdate") String birthdate,
			@RequestParam(value = "telnumber") String telnumber
			) 
	{

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}


		ClientDTO clientDTO= new ClientDTO();
			clientDTO.setName(name);
			clientDTO.setSurname(surname);
			clientDTO.setTelnumber(telnumber);
			clientDTO.setBirthdate(date);
			
			System.out.println(clientDTO.getName());
			
			clientService.insert(clientDTO);
			
			
			
			return "hometutor";
						
	}
	
}
