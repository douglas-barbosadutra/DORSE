package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.ApartmentDTO;
import it.contrader.dto.ThingDTO;
import it.contrader.dto.TutorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ApartmentService;
import it.contrader.service.OperatorService;
import it.contrader.service.SuperuserService;
import it.contrader.service.ThingService;
import it.contrader.service.TutorService;
import it.contrader.service.UserService;


@Controller
@RequestMapping("/thing")
public class ThingController {
	
 private ThingService thingService;

	public ThingController(ThingService thingService) {
		this.thingService = thingService;
	}
		
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			@RequestParam(value = "description") String description) 
	{
		ThingDTO thingDTO = new ThingDTO();
		thingDTO.setDescription(description);
		thingService.insert(thingDTO);		
		
		return "hometutor";
	}
	
}
