package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.ApartmentDTO;
import it.contrader.service.ApartmentService;


@Controller
@RequestMapping("/apartment")
public class ApartmentController {

	@Autowired
	public ApartmentController(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;	
	}

	private ApartmentService apartmentService;

	@RequestMapping(value = "/registerapartment", method = RequestMethod.POST)
	public String register(

			@RequestParam(value = "address") String address
			) 
	{
	
		ApartmentDTO apartmentDTO = new ApartmentDTO();
		apartmentDTO.setAddress(address);
		
		apartmentService.insert(apartmentDTO);

	return "hometutor";
	}
}
